package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.VentesApi;
import com.example.gestion_de_stock.dto.VentesDto;
import com.example.gestion_de_stock.service.VentesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class VentesController implements VentesApi {
    private final VentesService ventesService;

    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
