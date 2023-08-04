package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.dto.ArticleDto;
import com.example.gestion_de_stock.dto.LigneCommandeClientDto;
import com.example.gestion_de_stock.dto.LigneCommandeFournisseurDto;
import com.example.gestion_de_stock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
