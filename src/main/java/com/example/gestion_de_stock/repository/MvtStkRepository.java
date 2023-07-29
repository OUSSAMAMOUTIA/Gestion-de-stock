package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {
    Optional<MvtStk> findAllByArticleId(Integer idArticle);
}
