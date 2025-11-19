package com.lucas.work_well.service.impl;

import com.lucas.work_well.mapper.UserMapper;
import com.lucas.work_well.model.dto.UserDTO;
import com.lucas.work_well.model.entity.User;
import com.lucas.work_well.repository.UserRepository;
import com.lucas.work_well.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;
    private final MessageSource messageSource;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository repo, UserMapper mapper, MessageSource messageSource) {
        this.repo = repo;
        this.mapper = mapper;
        this.messageSource = messageSource;
    }

    @Override
    public UserDTO create(UserDTO dto) {

        
        repo.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException(
                messageSource.getMessage("email.exists", null, LocaleContextHolder.getLocale())
            );
        });

        
        User entity = mapper.toEntity(dto);

        
        entity.setSenha(encoder.encode(dto.getSenha()));

       
        entity.setRole("ROLE_USER");

        
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
