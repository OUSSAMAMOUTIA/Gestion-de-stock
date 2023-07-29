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
public class Fournisseur extends AbstractEntity {
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private String numTel;
    private Integer idEntreprise;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
