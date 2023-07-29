package com.example.gestion_de_stock.controller.api;

import java.util.List;

import com.example.gestion_de_stock.dto.FournisseurDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface FournisseurApi {

    @PostMapping("/fournisseurs/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping("/fournisseurs/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping("/fournisseurs/all")
    List<FournisseurDto> findAll();

    @DeleteMapping("/fournisseurs/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);

}
