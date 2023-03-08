package com.ex.petshop.petshop.controllers;

import com.ex.petshop.petshop.dtos.ClienteDto;
import com.ex.petshop.petshop.models.ClienteModel;
import com.ex.petshop.petshop.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<ClienteModel>> findAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClientById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findClienteById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ClienteModel> addClient(@RequestBody @Valid ClienteDto clienteDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") UUID id, @RequestBody ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findClienteById(id);
        if (!clienteModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");

        var clienteModel = clienteModelOptional.get();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findClienteById(id);
        if (!clienteModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }






}
