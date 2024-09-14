package lk.ijse.gdse.aad67.notecollector.controller;

import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(@RequestPart("firstName") String firstName, @RequestPart("lastName") String lastName, @RequestPart("email") String email, @RequestPart("password") String password, @RequestPart("profilePic") String profilePic) {

        // ProfilePic -----------> Base64
        String base64ProPic = AppUtil.ProfilePicToBase64(profilePic);

        // Todo: UserId generate
        String userId = AppUtil.generateUserId();

        //Todo: Build the Object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        buildUserDTO.setUserId(userId);
        return buildUserDTO;

    }
}
