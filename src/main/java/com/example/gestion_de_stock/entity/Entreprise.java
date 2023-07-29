package com.example.gestion_de_stock.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise extends AbstractEntity {
    private String nom;
    private String description;
    @Embedded
    private Adresse adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
