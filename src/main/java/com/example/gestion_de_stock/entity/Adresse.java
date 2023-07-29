package com.example.gestion_de_stock.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
    private String adresse1;
    private String adresse2;
    private String codePostal;
    private String pays;
    private String ville;
}
