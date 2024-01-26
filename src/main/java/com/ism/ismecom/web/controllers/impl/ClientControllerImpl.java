package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.data.repositories.CommandeRepository;
import com.ism.ismecom.services.ClientService;
import com.ism.ismecom.services.CommandeService;
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
    private  final ClientService clientService;
    private final CommandeService commandeService;
    @Override
    public String listerClient(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5",name = "size") int size,
            @RequestParam(defaultValue = "",name = "telephone") String telephone
    ) {
        //formulaire
        Page<Client> clients = clientService.getClientsWithPaginateAndFilter(PageRequest.of(page,size),telephone);
        model.addAttribute("clients",clients.getContent());
        //mettre le numero dans le placeholder ou le value du formulaire
        model.addAttribute("telephone", telephone);


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
    public String listeCommande(Model model,
                                @RequestParam(defaultValue = "0",name = "page") int page,
                                @RequestParam(defaultValue = "5",name = "size") int size,
                                long id
    ) {
        Page<Commande> commandes = commandeService.getCommandeByFiltre(PageRequest.of(page,size),id);
        model.addAttribute("commandes",commandes);

        /*
        * List<Client> client = clientService.getClientById(id);
        //un seul client donc
        if (!client.isEmpty()) {
            model.addAttribute("client", client.get(0));
        }*/

        return "commande";
    }


}
