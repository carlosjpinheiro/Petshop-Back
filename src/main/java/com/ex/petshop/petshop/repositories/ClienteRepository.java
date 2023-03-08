package com.ex.petshop.petshop.repositories;

import com.ex.petshop.petshop.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {


}
