package com.logone.authservice.dto;

import com.logone.authservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Role> roles = new ArrayList<>();
}
