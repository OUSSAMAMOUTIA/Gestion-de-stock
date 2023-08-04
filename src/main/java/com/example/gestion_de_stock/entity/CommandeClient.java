package com.example.gestion_de_stock.entity;

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
public class CommandeClient extends AbstractEntity{
    private String code;
    private Instant dateCommande;
    private Integer idEntreprise;
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
