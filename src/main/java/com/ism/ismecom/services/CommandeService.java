package com.ism.ismecom.services;

import com.ism.ismecom.data.entities.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> getCommandeByFiltre(Long id);
}
