package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Page<Commande> findCommandeById(Pageable page, Long id);
    //List<Client> findCommandeById(Long id);
    //Page<Commande> findCommandeByClientId(Long client_id,Pageable pageable);

    List<Commande> findCommandeByClientId(Long client_id);
    List<Commande> findCommandeById(Long id);

}
