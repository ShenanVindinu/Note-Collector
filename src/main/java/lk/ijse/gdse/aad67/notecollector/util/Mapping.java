package lk.ijse.gdse.aad67.notecollector.util;

import lk.ijse.gdse.aad67.notecollector.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollector.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for user mapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
}