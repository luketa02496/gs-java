package com.lucas.work_well.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    public UserDTO() {}

    public UserDTO(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
