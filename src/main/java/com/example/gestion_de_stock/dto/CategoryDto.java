package com.example.gestion_de_stock.dto;

import com.example.gestion_de_stock.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;
    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articles;
    public static CategoryDto fromEntity(Category category){
        if (category==null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .idEntreprise(category.getIdEntreprise())
                .designation(category.getDesignation())
                .build();
    }
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto==null){
            return null;
        }
       Category category=new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());
        return category;
    }
}
