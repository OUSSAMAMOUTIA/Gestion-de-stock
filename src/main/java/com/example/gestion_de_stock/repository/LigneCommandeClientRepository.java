package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
}
