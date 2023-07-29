package com.example.gestion_de_stock.controller.api;

import com.example.gestion_de_stock.dto.ArticleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

//@Tag(name = "articles")
public interface ArticleApi {

    @PostMapping("/articles/create")
    @Operation(summary = "Enregistrer un article", description = "Cette methode permet d'enregistrer ou modifier un article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet article cree / modifie",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class))}),
            @ApiResponse(responseCode = "400", description = "L'objet article n'est pas valide",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Article n'est pas trouvée",
                    content = @Content)})
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping("/articles/{idArticle}")
    @Operation(summary = "Rechercher un article par ID", description = "Cette methode permet de chercher un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class))}),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping("/articles/filter/{codeArticle}")
    @Operation(summary = "Rechercher un article par CODE", description = "Cette methode permet de chercher un article par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class))}),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = "/articles/all")
//    @Operation(summary = "Renvoi la liste des articles", description = "Cette methode permet de chercher et renvoyer la liste des articles qui existent "
//            + "dans la BDD")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "La liste des article / Une liste vide")
//    })
    List<ArticleDto> findAll();

//    @GetMapping( "/articles/historique/vente/{idArticle}")
//    List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);
//
//    @GetMapping( "/articles/historique/commandeclient/{idArticle}")
//    List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Integer idArticle);
//
//    @GetMapping( "/articles/historique/commandefournisseur/{idArticle}")
//    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);
//
//    @GetMapping( "/articles/filter/category/{idCategory}")
//    List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);

    @DeleteMapping("/articles/delete/{idArticle}")
    @Operation(summary = "Supprimer un article", description = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete supprime")
    })
    void delete(@PathVariable("idArticle") Integer id);

}