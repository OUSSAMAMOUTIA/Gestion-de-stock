package com.example.gestion_de_stock.repository;

import com.example.gestion_de_stock.entity.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

    Optional<Ventes> findVentesByCode(String code);
}
