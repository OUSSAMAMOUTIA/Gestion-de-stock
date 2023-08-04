package com.example.gestion_de_stock.entity;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private TypeMvtStk typeMvt;
    private Integer idEntreprise;
    @Enumerated(EnumType.STRING)
    private SourceMvtStk sourceMvt;
}
