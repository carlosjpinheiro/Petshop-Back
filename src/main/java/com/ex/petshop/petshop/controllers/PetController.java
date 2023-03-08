package com.ex.petshop.petshop.controllers;

import com.ex.petshop.petshop.dtos.PetAddClienteDto;
import com.ex.petshop.petshop.dtos.PetDto;
import com.ex.petshop.petshop.models.ClienteModel;
import com.ex.petshop.petshop.models.PetModel;
import com.ex.petshop.petshop.repositories.ClienteRepository;
import com.ex.petshop.petshop.services.ClienteService;
import com.ex.petshop.petshop.services.PetService;
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
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("")
    public ResponseEntity<List<PetModel>> findAllPets(){
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findPetById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(petService.findPetById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<PetModel> addPet(@RequestBody @Valid PetDto petDto){
        var petModel = new PetModel();
        BeanUtils.copyProperties(petDto, petModel);
        System.out.println(petModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(petModel));
    }

    @PostMapping("/setcliente")
    public ResponseEntity<PetModel> setClienteToPet(@RequestBody @Valid PetAddClienteDto petAddClienteDto){
        Optional<PetModel> petModelOptional = petService.findPetById(petAddClienteDto.getPetId());
        Optional<ClienteModel> clienteModelOptional = clienteService.findClienteById(petAddClienteDto.getClienteID());
        petModelOptional.get().setClienteResponsavel(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(petService.save(petModelOptional.get()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePet(@PathVariable(value = "id") UUID id, @RequestBody @Valid PetDto petDto){
        Optional<PetModel> petModelOptional = petService.findPetById(id);
        if (!petModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado!");

        var petModel = petModelOptional.get();
        BeanUtils.copyProperties(petDto, petModel);
        return ResponseEntity.status(HttpStatus.OK).body(petService.save(petModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePet(@PathVariable(value = "id") UUID id){
        Optional<PetModel> petModelOptional = petService.findPetById(id);
        if (!petModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado!");
        petService.delete(petModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pet deletado com sucesso!");
    }





}
