package com.ism.ismecom.services.impl;

import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.repositories.CommandeRepository;
import com.ism.ismecom.services.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {
    //injection de dependance
    private  final CommandeRepository commandeRepository;

    @Override
    public Page<Commande> getAllCommande(Pageable page) {
        return commandeRepository.findAllByActiveTrue(page);
    }

    @Override
    public Page<Commande> getCommandeByClient(Long id,Pageable pageable) {
        return commandeRepository.findCommandesByClientId(id,pageable);
    }
}
