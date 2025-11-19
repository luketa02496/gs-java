package com.lucas.work_well.controller;

import com.lucas.work_well.model.dto.UserDTO;
import com.lucas.work_well.model.dto.UserResponseDTO;
import com.lucas.work_well.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserDTO dto) {
        UserDTO created = svc.create(dto);

        UserResponseDTO response = new UserResponseDTO(
                created.getId(),
                created.getNome(),
                created.getEmail()
        );

        return ResponseEntity.status(201).body(response);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        return svc.findById(id)
                .map(user -> ResponseEntity.ok(
                        new UserResponseDTO(
                                user.getId(),
                                user.getNome(),
                                user.getEmail()
                        )
                ))
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getByEmail(@PathVariable String email) {
        return svc.findByEmail(email)
                .map(user -> ResponseEntity.ok(
                        new UserResponseDTO(
                                user.getId(),
                                user.getNome(),
                                user.getEmail()
                        )
                ))
                .orElse(ResponseEntity.notFound().build());
    }
}
