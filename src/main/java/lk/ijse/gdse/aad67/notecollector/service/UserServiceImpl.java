package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dao.UserDAO;
import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.notecollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity user = mapping.toUserEntity(userDTO);
        UserEntity save = userDAO.save(user);
        return mapping.toUserDTO(save);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }
}
