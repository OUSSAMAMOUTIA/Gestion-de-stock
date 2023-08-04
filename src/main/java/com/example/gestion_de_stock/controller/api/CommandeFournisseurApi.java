package com.example.gestion_de_stock.controller.api;

import com.example.gestion_de_stock.dto.CommandeFournisseurDto;
import com.example.gestion_de_stock.dto.LigneCommandeFournisseurDto;

import java.math.BigDecimal;
import java.util.List;

import com.example.gestion_de_stock.entity.EtatCommande;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommandeFournisseurApi {
    @PostMapping("/commandesfournisseurs/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @PatchMapping("/commandesfournisseurs/update/etat/{idcommande}/{etatcommande}")
    CommandeFournisseurDto updateEtatCommande(@PathVariable("idcommande") Integer idCommande, @PathVariable("etatcommande") EtatCommande etatCommande);

    @PatchMapping("/commandesfournisseurs/update/quantite/{idcommande}/{idligneCommande}/{quantite}")
    CommandeFournisseurDto updateQuantiteCommande(@PathVariable("idcommande") Integer idCommande,
                                                  @PathVariable("idligneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping("/commandesfournisseurs/update/fournisseur/{idcommande}/{idfournisseur}")
    CommandeFournisseurDto updateFournisseur(@PathVariable("idcommande") Integer idCommande, @PathVariable("idfournisseur") Integer idFournisseur);

    @PatchMapping( "/commandesfournisseurs/update/article/{idcommande}/{idligneCommande}/{idarticle}")
    CommandeFournisseurDto updateArticle(@PathVariable("idcommande") Integer idCommande,
                                         @PathVariable("idligneCommande") Integer idLigneCommande, @PathVariable("idarticle") Integer idArticle);

    @DeleteMapping( "/commandesfournisseurs/delete/article/{idcommande}/{idligneCommande}")
    CommandeFournisseurDto deleteArticle(@PathVariable("idcommande") Integer idCommande, @PathVariable("idligneCommande") Integer idLigneCommande);

    @GetMapping("/commandesfournisseurs/{idcommandefournisseur}")
    CommandeFournisseurDto findById(@PathVariable("idcommandefournisseur") Integer id);

    @GetMapping("/commandesfournisseurs/commande/{codecommandefournisseur}")
    CommandeFournisseurDto findByCode(@PathVariable("codecommandefournisseur") String code);

    @GetMapping("/commandesfournisseurs")
    List<CommandeFournisseurDto> findAll();

    @GetMapping(  "/commandesfournisseurs/lignesCommande/{idcommande}")
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(@PathVariable("idcommande") Integer idCommande);

    @DeleteMapping("/commandesfournisseurs/delete/{idcommandefournisseur}")
    void delete(@PathVariable("idcommandefournisseur") Integer id);
}
