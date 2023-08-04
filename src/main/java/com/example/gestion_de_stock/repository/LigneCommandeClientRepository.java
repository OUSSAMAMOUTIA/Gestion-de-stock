package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
