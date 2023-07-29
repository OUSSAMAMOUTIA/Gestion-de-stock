package com.example.gestion_de_stock.entity;

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
public class Category extends AbstractEntity {
    private String code;
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
    private Integer idEntreprise;
}
