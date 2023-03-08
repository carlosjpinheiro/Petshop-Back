package com.ex.petshop.petshop.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class PetAddClienteDto {

    private UUID petId;
    private UUID clienteID;


}
