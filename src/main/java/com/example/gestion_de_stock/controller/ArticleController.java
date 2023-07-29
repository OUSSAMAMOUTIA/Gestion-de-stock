package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.ArticleApi;
import com.example.gestion_de_stock.dto.ArticleDto;
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
}
