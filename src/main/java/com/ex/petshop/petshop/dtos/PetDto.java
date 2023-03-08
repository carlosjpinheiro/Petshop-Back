package com.ex.petshop.petshop.dtos;

import com.ex.petshop.petshop.enums.TipoTratamentoEnum;
import lombok.Data;

@Data
public class PetDto {

    private String nome;
    private String especie;
    private String raca;
    private double altura;
    private double peso;
    private String tipoPelagem;
    private TipoTratamentoEnum tipoTratamento;

}
