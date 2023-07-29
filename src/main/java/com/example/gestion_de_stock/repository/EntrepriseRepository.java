package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
