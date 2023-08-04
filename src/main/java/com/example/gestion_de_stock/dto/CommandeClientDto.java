package com.example.gestion_de_stock.dto;

import com.example.gestion_de_stock.entity.CommandeClient;
import com.example.gestion_de_stock.entity.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private ClientDto client;
    private EtatCommande etatCommande;
    private List<LigneCommandeClientDto> ligneCommandeClients;
    private Integer idEntreprise;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .idEntreprise(commandeClient.getIdEntreprise())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setIdEntreprise(dto.getIdEntreprise());
        commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
        commandeClient.setEtatCommande(dto.getEtatCommande());
        commandeClient.setDateCommande(dto.getDateCommande());
        return commandeClient;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
