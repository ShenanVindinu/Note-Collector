package lk.ijse.gdse.aad67.notecollector.controller;

import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.service.UserService;
import lk.ijse.gdse.aad67.notecollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") MultipartFile profilePic
    ) {

        // ProfilePic -----------> Base64
        String base64ProPic = "";

        try {
            byte[] bytes = profilePic.getBytes();
            base64ProPic = AppUtil.ProfilePicToBase64(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userId = AppUtil.generateUserId();

        //Todo: Build the Object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        buildUserDTO.setUserId(userId);
        return userService.saveUser(buildUserDTO);

    }

    @GetMapping(value = "/{userId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping( "/{userId}" )
    public void deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") MultipartFile profilePic,
            @PathVariable("/{userId}") String userId
    ){

        String base64ProPic = "";

        try {
            byte[] bytesProPic = profilePic.getBytes();
            base64ProPic = AppUtil.ProfilePicToBase64(bytesProPic);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        userService.updateUser(userId, buildUserDTO);

    }
}
