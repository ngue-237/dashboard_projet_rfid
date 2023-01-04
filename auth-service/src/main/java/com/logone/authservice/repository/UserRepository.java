package com.logone.authservice.repository;

import com.logone.authservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
