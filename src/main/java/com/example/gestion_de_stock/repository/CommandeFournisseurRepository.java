package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.CommandeClient;
import com.example.gestion_de_stock.entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);

}
