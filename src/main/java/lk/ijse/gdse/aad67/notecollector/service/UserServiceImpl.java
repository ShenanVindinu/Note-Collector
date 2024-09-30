package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dao.UserDAO;
import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.entity.impl.UserEntity;
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
      UserEntity selectedUser = userDAO.getReferenceById(userId);
      return mapping.toUserDTO(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userDAO.deleteById(userId);
    }

    @Override
    public void updateUser(String userId,UserDTO userDTO) {
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
