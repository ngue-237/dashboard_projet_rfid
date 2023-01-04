package com.logone.authservice.mappers;

import com.logone.authservice.dto.UserRequestDTO;
import com.logone.authservice.dto.UserResponseDTO;
import com.logone.authservice.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO fromUserEntity(UserEntity userEntity);
    UserEntity fromUserRequestDTO(UserRequestDTO userRequestDTO);
}
