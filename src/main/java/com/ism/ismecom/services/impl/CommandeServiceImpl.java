package com.ism.ismecom.services.impl;

import com.ism.ismecom.data.entities.*;
import com.ism.ismecom.data.enums.EtatCommande;
import com.ism.ismecom.data.repositories.ArticleRepository;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.data.repositories.CommandeRepository;
import com.ism.ismecom.data.repositories.LigneCommandeRepository;
import com.ism.ismecom.services.CommandeService;
import com.ism.ismecom.web.dto.request.PanierDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Service
//insertion sur les deux pas faite ? cool, tu valides : tu t'arrêtes
@Transactional
public class CommandeServiceImpl implements CommandeService {
    //injection de dependance
    private  final CommandeRepository commandeRepository;
    private  final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    @Override
    public Page<Commande> getAllCommande(Pageable page) {
        return commandeRepository.findAllByActiveTrue(page);
    }

    @Override
    public Page<Commande> getCommandeByClient(Long id,Pageable pageable) {
        return commandeRepository.findCommandesByClientId(id,pageable);
    }

    @Override
    public void saveCommande(PanierDto panier) {
        //Ligne de commande, c'est une liste et panier.getArticlesPanier() et de type article dto → convertir Article donc on stream
        Client client = clientRepository.findById(panier.getClient().getId()).orElse(null);
        if(client!=null){
            Date dateCommande = new Date();

            Commande commande = new Commande(
                    dateCommande,
                    panier.getTotal(),
                    EtatCommande.Encours,
                    null,
                    client,
                    null
            );
            commandeRepository.save(commande);
            //les ligne de commandes
            List<LigneCommande> ligneCommande = panier.getArticlesPanier().stream().map(
                articlePanierDto -> {
                    Article article = articleRepository.findById(articlePanierDto.getId()).orElseThrow(
                            ()-> new RuntimeException("L'article n'existe pas ! ")
                    );

                    return new LigneCommande(
                            articlePanierDto.getMontant(),
                            articlePanierDto.getQuantite(),
                            articlePanierDto.getPrix(),
                            article,
                            commande
                    );
                }).toList();
                ligneCommandeRepository.saveAllAndFlush(ligneCommande);

        }


    }
}
