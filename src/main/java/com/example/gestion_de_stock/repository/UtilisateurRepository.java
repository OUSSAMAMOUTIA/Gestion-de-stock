package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
