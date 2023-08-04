package com.example.gestion_de_stock.service.impl;

import com.example.gestion_de_stock.dto.ArticleDto;
import com.example.gestion_de_stock.dto.LigneCommandeClientDto;
import com.example.gestion_de_stock.dto.LigneCommandeFournisseurDto;
import com.example.gestion_de_stock.dto.LigneVenteDto;
import com.example.gestion_de_stock.entity.Article;
import com.example.gestion_de_stock.entity.LigneCommandeClient;
import com.example.gestion_de_stock.entity.LigneCommandeFournisseur;
import com.example.gestion_de_stock.entity.LigneVente;
import com.example.gestion_de_stock.exception.EntityNotFoundException;
import com.example.gestion_de_stock.exception.ErrorCodes;
import com.example.gestion_de_stock.exception.InvalidEntityException;
import com.example.gestion_de_stock.exception.InvalidOperationException;
import com.example.gestion_de_stock.repository.ArticleRepository;
import com.example.gestion_de_stock.repository.LigneCommandeClientRepository;
import com.example.gestion_de_stock.repository.LigneCommandeFournisseurRepository;
import com.example.gestion_de_stock.repository.LigneVenteRepository;
import com.example.gestion_de_stock.service.ArticleService;
import com.example.gestion_de_stock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final LigneVenteRepository venteRepository;
    private final LigneCommandeFournisseurRepository commandeFournisseurRepository;
    private final LigneCommandeClientRepository commandeClientRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, LigneVenteRepository venteRepository, LigneCommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeClientRepository commandeClientRepository) {
        this.articleRepository = articleRepository;
        this.venteRepository = venteRepository;
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valide ", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        Article savedArticle = articleRepository.save(ArticleDto.toEntity(articleDto));

        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }
        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return venteRepository.findAllByArticleId(idArticle).stream()
                .map(LigneVenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
        return commandeClientRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return commandeFournisseurRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleRepository.findAllByCategoryId(idCategory).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
        if (!ligneCommandeFournisseurs.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        articleRepository.deleteById(id);
    }
}
