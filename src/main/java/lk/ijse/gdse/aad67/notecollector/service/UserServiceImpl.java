package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dao.UserDAO;
import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.notecollector.exception.DataPersistException;
import lk.ijse.gdse.aad67.notecollector.exception.UserNotFoundException;
import lk.ijse.gdse.aad67.notecollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser =
                userDAO.save(mapping.toUserEntity(userDTO));
        if (savedUser != null) {
            throw new DataPersistException("User not Saved");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser = userDAO.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existedUser = userDAO.findById(userId);
        if (existedUser.isEmpty()) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        } else {
            userDAO.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDAO.findById(userId);
        if (tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }


}
