package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.FournisseurApi;
import com.example.gestion_de_stock.dto.FournisseurDto;
import com.example.gestion_de_stock.service.FournisseurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class FournisseurController implements FournisseurApi {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
