package com.lucas.work_well.service;

import com.lucas.work_well.model.dto.UserDTO;
import com.lucas.work_well.model.entity.User;

import java.util.Optional;

public interface UserService {
    UserDTO create(UserDTO dto);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
