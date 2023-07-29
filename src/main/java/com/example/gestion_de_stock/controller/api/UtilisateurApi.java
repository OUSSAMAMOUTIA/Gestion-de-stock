package com.example.gestion_de_stock.controller.api;

import java.util.List;

import com.example.gestion_de_stock.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UtilisateurApi {

    @PostMapping("/utilisateurs/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

//    @PostMapping("/utilisateurs/update/password")
//    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping("/utilisateurs/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

//    @GetMapping("/utilisateurs/find/{email}")
//    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping("/utilisateurs/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping("/utilisateurs/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}