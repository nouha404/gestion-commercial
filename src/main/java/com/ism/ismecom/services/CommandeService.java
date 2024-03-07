package com.ism.ismecom.services;

import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.web.dto.request.PanierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommandeService {

    Page<Commande> getAllCommande(Pageable page);
    Page<Commande> getCommandeByClient(Long id,Pageable pageable);
    void saveCommande(PanierDto panier);
}
