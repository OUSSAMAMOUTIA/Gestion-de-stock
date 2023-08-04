package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.CommandeClientApi;
import com.example.gestion_de_stock.dto.CommandeClientDto;
import com.example.gestion_de_stock.dto.LigneCommandeClientDto;
import com.example.gestion_de_stock.entity.EtatCommande;
import com.example.gestion_de_stock.service.CommandeClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class CommandeClientController implements CommandeClientApi {
    private final CommandeClientService commandeClientService;

    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeClientService.updateEtatCommande(idCommande, etatCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDto> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return ResponseEntity.ok(commandeClientService.updateQuantiteCommande(idCommande, idLigneCommande, quantite));
    }

    @Override
    public ResponseEntity<CommandeClientDto> updateClient(Integer idCommande, Integer idClient) {
        return ResponseEntity.ok(commandeClientService.updateClient(idCommande, idClient));
    }

    @Override
    public ResponseEntity<CommandeClientDto> updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
        return ResponseEntity.ok(commandeClientService.updateArticle(idCommande, idLigneCommande, idArticle));
    }

    @Override
    public ResponseEntity<CommandeClientDto> deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return ResponseEntity.ok(commandeClientService.deleteArticle(idCommande, idLigneCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
        return ResponseEntity.ok(commandeClientService.findAllLignesCommandesClientByCommandeClientId(idCommande));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
