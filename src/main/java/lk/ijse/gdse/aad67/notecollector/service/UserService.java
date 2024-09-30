package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUser(String userId);

    void deleteUser(String userId);

    void updateUser(String userId,UserDTO userDTO);
}
