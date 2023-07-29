package com.example.gestion_de_stock.dto;

import com.example.gestion_de_stock.entity.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {
    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;
    private List<LigneVenteDto> ligneVentes;

    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDto ventesDto) {
        if (ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setCommentaire(ventesDto.getCommentaire());
        ventes.setIdEntreprise(ventesDto.getIdEntreprise());
        return ventes;
    }
}
