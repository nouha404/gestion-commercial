package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.services.ClientService;
import com.ism.ismecom.services.CommandeService;
import com.ism.ismecom.web.controllers.CommandeController;
import com.ism.ismecom.web.dto.response.CommandeShowEntityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommandeControllerImpl implements CommandeController {
    //injection de dependance
    private final CommandeService commandeService;
    private final ClientService clientService;

    @Override
    public String listeCommande(Model model,
                                @RequestParam(defaultValue = "0",name = "page") int page,
                                @RequestParam(defaultValue = "3",name = "size") int size,
                                @RequestParam("id") long id
    ) {


        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandes = commandeService.getCommandeByClient(id,pageable);
        //transformer objet type Commande => commandeDto
        Page<CommandeShowEntityResponseDto> commandesDto = commandes.map(CommandeShowEntityResponseDto::toDto);
        model.addAttribute("commandes",commandesDto);

        model.addAttribute("clientId",id);
        model.addAttribute("pages",new int[commandes.getTotalPages()]);
        //position de la page
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < commandes.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);




        return "Commande/commandeUnClient";
    }

    @Override
    public String listerAllCommande(Model model,
                        @RequestParam(defaultValue = "0",name = "page") int page,
                        @RequestParam(defaultValue = "5",name = "size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> allCommandes = commandeService.getAllCommande(pageable);
        model.addAttribute("commandes",allCommandes);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < allCommandes.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        System.out.println(allCommandes);
        return "Commande/commande";
    }


}
