package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Page<Commande> findCommandeById(Pageable page, Long id);

    List<Commande> findCommandeById(Long id);
    Page<Commande> findAllByActiveTrue(Pageable page);
    Page<Commande> findCommandesByClientId(Long id,Pageable page);



}
