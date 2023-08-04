package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.dto.ChangerMotDePasseUtilisateurDto;
import com.example.gestion_de_stock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);


    UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
