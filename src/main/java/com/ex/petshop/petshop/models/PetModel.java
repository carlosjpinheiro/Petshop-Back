package com.ex.petshop.petshop.models;

import com.ex.petshop.petshop.enums.TipoTratamentoEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_pet")
public class PetModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String especie;
    @Column
    private String raca;
    @Column
    private double altura;
    @Column
    private double peso;
    @Column
    private String tipoPelagem;
    @Column
    private TipoTratamentoEnum tipoTratamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel clienteResponsavel;

    public PetModel(){}

    public PetModel(UUID id, String nome, String especie, String raca, double altura, double peso, String tipoPelagem, TipoTratamentoEnum tipoTratamento, ClienteModel clienteResponsavel) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.altura = altura;
        this.peso = peso;
        this.tipoPelagem = tipoPelagem;
        this.tipoTratamento = tipoTratamento;
        this.clienteResponsavel = clienteResponsavel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipoPelagem() {
        return tipoPelagem;
    }

    public void setTipoPelagem(String tipoPelagem) {
        this.tipoPelagem = tipoPelagem;
    }

    public TipoTratamentoEnum getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(TipoTratamentoEnum tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public ClienteModel getClienteResponsavel() {
        return clienteResponsavel;
    }

    public void setClienteResponsavel(ClienteModel clienteResponsavel) {
        this.clienteResponsavel = clienteResponsavel;
    }
}
