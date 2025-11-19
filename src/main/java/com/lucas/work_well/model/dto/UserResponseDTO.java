package com.lucas.work_well.model.dto;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public UserResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
