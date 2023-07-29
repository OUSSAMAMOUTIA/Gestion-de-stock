package com.example.gestion_de_stock.controller;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

import com.example.gestion_de_stock.controller.api.CommandeFournisseurApi;
import com.example.gestion_de_stock.dto.CommandeFournisseurDto;
import com.example.gestion_de_stock.service.CommandeFournisseurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(APP_ROOT)
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
    private final CommandeFournisseurService commandeFournisseurService;

    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
