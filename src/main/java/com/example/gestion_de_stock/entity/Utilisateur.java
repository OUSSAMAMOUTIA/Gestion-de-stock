package com.example.gestion_de_stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur extends AbstractEntity {
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String photo;
    private Instant dateDeNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    @JsonIgnore
    private List<Roles> roles;
}
