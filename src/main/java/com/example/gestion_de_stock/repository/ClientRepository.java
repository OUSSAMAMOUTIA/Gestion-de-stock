package com.example.gestion_de_stock.repository;


import com.example.gestion_de_stock.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
