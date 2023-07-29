package com.example.gestion_de_stock.controller.api;

import com.example.gestion_de_stock.dto.ClientDto;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {
    @PostMapping(value = "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = "/clients/{idclient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById( @PathVariable("idclient") Integer id);

    @GetMapping(value = "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping("/clients/delete/{idclient}")
    void delete(@PathVariable("idclient") Integer id);
}
