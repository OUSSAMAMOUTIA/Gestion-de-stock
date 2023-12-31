package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
     Optional<Utilisateur> findUtilisateurByEmail(String email);
     Optional<Utilisateur> findByPrenom(String prenom);

}
