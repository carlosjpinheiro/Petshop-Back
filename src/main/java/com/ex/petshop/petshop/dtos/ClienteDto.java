package com.ex.petshop.petshop.dtos;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ClienteDto {

    private String nome;
    private String dataNascimento;
    @Email
    private String email;
    private String telefone;
}
