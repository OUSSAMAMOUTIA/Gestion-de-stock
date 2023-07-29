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
public class Client extends AbstractEntity {
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private String numTel;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
    private Integer idEntreprise;
}
