package com.ex.petshop.petshop.services;

import com.ex.petshop.petshop.models.PetModel;
import com.ex.petshop.petshop.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;


    public List<PetModel> findAll() {
        return petRepository.findAll();
    }

    public Optional<PetModel> findPetById(UUID id) {
        return petRepository.findById(id);
    }
    @Transactional
    public PetModel save(PetModel petModel) {
        return petRepository.save(petModel);
    }
    @Transactional
    public void delete(PetModel petModel) {
        petRepository.delete(petModel);
    }
}
