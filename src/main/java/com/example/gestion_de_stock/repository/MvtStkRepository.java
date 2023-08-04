package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {
    List<MvtStk> findAllByArticleId(Integer idArticle);

    @Query("select sum(m.quantite) from MvtStk m where m.article.id = :idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);
}
