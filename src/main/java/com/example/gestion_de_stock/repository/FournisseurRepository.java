package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
