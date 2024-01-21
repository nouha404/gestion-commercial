package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.data.repositories.CommandeRepository;
import com.ism.ismecom.web.controllers.ClientController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ClientControllerImpl implements ClientController {
    //injection par contructeur
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;
    @Override
    public String listerClient(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5",name = "size") int size
    ) {

        Page<Client> clients =  clientRepository.findAllByActiveTrue(PageRequest.of(page,size));
        model.addAttribute("clients",clients.getContent());
        //creer un tableau pour le nombre de pages
        model.addAttribute("pages",new int[clients.getTotalPages()]);
        //position de la page
        model.addAttribute("currentPage",page);

        //next page : verifie si page est < nombre total de pages disponibles
        model.addAttribute("nextPage", page < clients.getTotalPages() - 1 ? page+1:page);
        //previous page idem
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);
        return "client";
    }

    @Override
    public String listeCommande(Model model, long id) {
        List<Commande> commandes = commandeRepository.findCommandeById(id);
        //Page<Commande> commandes = commandeRepository.findCommandeByClientId(id,PageRequest.of(0, 10));
        model.addAttribute("commandes",commandes);

        List<Client> client = clientRepository.findClientById(id);

        //un seul client donc
        if (!client.isEmpty()) {
            model.addAttribute("client", client.get(0));
        }


        return "commande";
    }


}
