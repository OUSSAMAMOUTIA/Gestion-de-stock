package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.ArticleApi;
import com.example.gestion_de_stock.dto.ArticleDto;
import com.example.gestion_de_stock.dto.LigneCommandeClientDto;
import com.example.gestion_de_stock.dto.LigneCommandeFournisseurDto;
import com.example.gestion_de_stock.dto.LigneVenteDto;
import com.example.gestion_de_stock.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class ArticleController implements ArticleApi {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    public void delete(Integer id) {
        articleService.delete(id);
    }

    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return articleService.findHistoriqueVentes(idArticle);
    }

    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
        return articleService.findHistoriaueCommandeClient(idArticle);
    }

    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleService.findAllArticleByIdCategory(idCategory);
    }
}
