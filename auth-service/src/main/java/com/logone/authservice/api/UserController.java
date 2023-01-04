package com.logone.authservice.api;

import com.logone.authservice.dto.AuthResponseDTO;
import com.logone.authservice.dto.LoginDTO;
import com.logone.authservice.dto.UserRequestDTO;
import com.logone.authservice.dto.UserResponseDTO;
import com.logone.authservice.security.JWTGenerator;
import com.logone.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class UserController {
    private  UserService userService;
    private  AuthenticationManager authenticationManager;
    private JWTGenerator jwtGenerator;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> addNewUser(@RequestBody UserRequestDTO userRequestDTO){
        if(this.userService.userExistByEmail(userRequestDTO.getEmail()))
            return  ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(this.userService.saveUser(userRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new  ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
