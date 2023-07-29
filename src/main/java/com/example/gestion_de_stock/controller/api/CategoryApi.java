package com.example.gestion_de_stock.controller.api;

import com.example.gestion_de_stock.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {
    @PostMapping("/categories/create")
    @Operation(summary = "Enregistrer une categorie", description = "Cette methode permet d'enregistrer ou modifier une categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet category cree / modifie",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "400", description = "L'objet category n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping("/categories/{idcategory}")
    @Operation(summary = "Rechercher une categorie par ID", description = "Cette methode permet de chercher une categorie par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La categorie a ete trouve dans la BDD",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Aucune categorie n'existe dans la BDD avec l'ID fourni")
    })
    CategoryDto findById(@PathVariable("idcategory") Integer idcategory);

    @GetMapping("/categories/filter/{codecategory}")
    @Operation(summary = "Rechercher une categorie par CODE", description = "Cette methode permet de chercher une categorie par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findByCode(@Parameter(example = "CAT1") @PathVariable("codecategory") String codeCategory);

    @GetMapping("/categories/all")
    @Operation(summary = "Renvoi la liste des categories", description = "Cette methode permet de chercher et renvoyer la liste des categories qui existent "
            + "dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des article / Une liste vide",
                    content = {@Content(mediaType = "application/json")}),
    })
    List<CategoryDto> findAll();

    @DeleteMapping("/categories/delete/{idcategory}")
    @Operation(summary = "Supprimer un article", description = "Cette methode permet de supprimer une categorie par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La categorie a ete supprime")
    })
    void delete(@PathVariable("idcategory") Integer id);
}
