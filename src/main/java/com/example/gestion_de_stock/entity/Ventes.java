package com.example.gestion_de_stock.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ventes extends AbstractEntity {
    private String code;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;
}
