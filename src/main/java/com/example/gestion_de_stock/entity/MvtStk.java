package com.example.gestion_de_stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MvtStk extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    private Instant dateMvt;
    private BigDecimal quantite;
    private TypeMvtStk typeMvt;
    private Integer idEntreprise;
}
