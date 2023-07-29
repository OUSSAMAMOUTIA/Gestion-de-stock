package com.example.gestion_de_stock.controller.api;
import java.util.List;

import com.example.gestion_de_stock.dto.EntrepriseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
public interface EntrepriseApi {
    @PostMapping("/entreprises/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping("/entreprises/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping("/entreprises/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping("/entreprises/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
