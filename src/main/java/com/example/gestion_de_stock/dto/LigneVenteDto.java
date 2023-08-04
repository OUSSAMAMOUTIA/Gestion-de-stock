package com.example.gestion_de_stock.dto;

import com.example.gestion_de_stock.entity.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Integer id;
    private VentesDto vente;
    private BigDecimal quantite;
    private ArticleDto article;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;
    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VentesDto.fromEntity(ligneVente.getVente()))
                .quantite(ligneVente.getQuantite())
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setVente(VentesDto.toEntity(ligneVenteDto.getVente()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
        return ligneVente;
    }

}
