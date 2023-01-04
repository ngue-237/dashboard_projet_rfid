package com.logone.authservice.service;

import com.logone.authservice.dto.UserRequestDTO;
import com.logone.authservice.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO saveUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAllUser();
    UserResponseDTO getUserById( Long id);
    Boolean userExistByEmail(String email);
}
