package com.example.gestion_de_stock.dto;

import com.example.gestion_de_stock.entity.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private String numTel;
    private Integer idEntreprise;
    private AdresseDto adresse;
   @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;
    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .idEntreprise(fournisseur.getIdEntreprise())
                .numTel(fournisseur.getNumTel())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        return fournisseur;
    }
}
