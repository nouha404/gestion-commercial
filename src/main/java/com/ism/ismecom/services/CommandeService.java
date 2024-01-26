package com.ism.ismecom.services;

import com.ism.ismecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommandeService {
    List<Commande> getCommandeByFiltre(Long id);
    Page<Commande> getCommandeByFiltre(Pageable page, Long id);
}
