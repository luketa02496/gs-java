package com.lucas.work_well.service.impl;

import com.lucas.work_well.mapper.UserMapper;
import com.lucas.work_well.model.dto.UserDTO;
import com.lucas.work_well.model.entity.User;
import com.lucas.work_well.repository.UserRepository;
import com.lucas.work_well.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        
        repo.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("Email já cadastrado");
        });
        User entity = mapper.toEntity(dto);
        User saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Cacheable("users")
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
