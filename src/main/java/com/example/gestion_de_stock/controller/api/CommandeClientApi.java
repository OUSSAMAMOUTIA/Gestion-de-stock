package com.example.gestion_de_stock.controller.api;

import com.example.gestion_de_stock.dto.CommandeClientDto;
import com.example.gestion_de_stock.dto.LigneCommandeClientDto;
import com.example.gestion_de_stock.entity.EtatCommande;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientApi {

    @PostMapping("/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @PatchMapping("/commandesclients/update/etat/{idCommande}/{etatcommande}")
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatcommande") EtatCommande etatCommande);

    @PatchMapping("/commandesclients/update/quantite/{idcommande}/{idlignecommande}/{quantite}")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idcommande") Integer idCommande,
                                                             @PathVariable("idlignecommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping("/commandesclients/update/client/{idcommande}/{idclient}")
    ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idcommande") Integer idCommande, @PathVariable("idclient") Integer idClient);

    @PatchMapping("/commandesclients/update/article/{idcommande}/{idlignecommande}/{idArticle}")
    ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idcommande") Integer idCommande,
                                                    @PathVariable("idlignecommande") Integer idLigneCommande, @PathVariable("idArticle") Integer idArticle);

    @DeleteMapping("/commandesclients/delete/article/{idcommande}/{idlignecommande}")
    ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idcommande") Integer idCommande, @PathVariable("idlignecommande") Integer idLigneCommande);

    @GetMapping("/commandesclients/{idcommandeclient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idcommandeclient);

    @GetMapping("/commandesclients/filter/{codecommandeclient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codecommandeclient") String code);

    @GetMapping("/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @GetMapping("/commandesclients/lignescommande/{idcommande}")
    ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(@PathVariable("idcommande") Integer idCommande);

    @DeleteMapping("/commandesclients/delete/{idcommandeclient}")
    ResponseEntity<Void> delete(@PathVariable("idcommandeclient") Integer id);
}
