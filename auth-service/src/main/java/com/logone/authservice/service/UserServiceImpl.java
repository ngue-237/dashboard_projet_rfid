package com.logone.authservice.service;

import com.logone.authservice.dto.UserRequestDTO;
import com.logone.authservice.dto.UserResponseDTO;
import com.logone.authservice.entity.Role;
import com.logone.authservice.entity.UserEntity;
import com.logone.authservice.mappers.UserMapper;
import com.logone.authservice.repository.RoleRepository;
import com.logone.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        UserEntity user = this.userMapper.fromUserRequestDTO(userRequestDTO);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepository.findByRoleName("ROLE_ADMIN");
        user.setRoles(Collections.singletonList(role));
        UserEntity userSaved = this.userRepository.save(user);
        return this.userMapper.fromUserEntity(userSaved);
    }

    @Override
    public List<UserResponseDTO> getAllUser() {
        List<UserEntity> users= this.userRepository.findAll();
        return users.stream()
                .map(userMapper::fromUserEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return this.userMapper.fromUserEntity(this.userRepository.findById(id).get());
    }

    @Override
    public Boolean userExistByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
