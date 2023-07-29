package com.example.gestion_de_stock.service.impl;

import com.example.gestion_de_stock.dto.LigneVenteDto;
import com.example.gestion_de_stock.dto.VentesDto;
import com.example.gestion_de_stock.entity.Article;
import com.example.gestion_de_stock.entity.LigneVente;
import com.example.gestion_de_stock.entity.Ventes;
import com.example.gestion_de_stock.exception.EntityNotFoundException;
import com.example.gestion_de_stock.exception.ErrorCodes;
import com.example.gestion_de_stock.exception.InvalidEntityException;
import com.example.gestion_de_stock.repository.ArticleRepository;
import com.example.gestion_de_stock.repository.LigneVenteRepository;
import com.example.gestion_de_stock.repository.VentesRepository;
import com.example.gestion_de_stock.service.VentesService;
import com.example.gestion_de_stock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {
    private final VentesRepository ventesRepository;
    private final ArticleRepository articleRepository;
    private final LigneVenteRepository ligneVenteRepository;

    public VentesServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository) {
        this.ventesRepository = ventesRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
//            updateMvtStk(ligneVente);
        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
//        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVenteId(id);
//        if (!ligneVentes.isEmpty()) {
//            throw new InvalidOperationException("Impossible de supprimer une vente ...",
//                    ErrorCodes.VENTE_ALREADY_IN_USE);
//        }
        ventesRepository.deleteById(id);
    }
}
