package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.services.ArticleService;
import com.ism.ismecom.services.ClientService;
import com.ism.ismecom.services.CommandeService;
import com.ism.ismecom.web.controllers.CommandeController;
import com.ism.ismecom.web.dto.request.PanierDto;
import com.ism.ismecom.web.dto.response.ArticleSimpleResponseDto;
import com.ism.ismecom.web.dto.response.ClientShowEntityResponseDto;
import com.ism.ismecom.web.dto.response.CommandeShowEntityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class CommandeControllerImpl implements CommandeController {
    //injection de dependance
    private final CommandeService commandeService;
    private final ArticleService articleService;
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

    //bean panier pour la session
    @ModelAttribute("panier")
    public PanierDto panier(){return new PanierDto(
            new ArrayList<>(),0,null);
    }
    @Override
    public String showFormCommande(
            Model model,
           @RequestParam(name="id") long id,
            @ModelAttribute("panier") PanierDto panier
    ) {
        List<Article> articles = articleService.getArticlesFormCommande();
        Client clientById = clientService.getClById(id);
        if (clientById == null){
            return "redirect:/liste-client";
        }
        // Transformer Client en ClientShowEntityResponseDto
        ClientShowEntityResponseDto clientDto = ClientShowEntityResponseDto.toDto(clientById);
        panier.setClient(clientDto);
        //panier.setClient(ClientShowEntityResponseDto.toDto(clientById)); erreur quand je fais ca ? so j'ai mis setClient dans PanierDto
        //panier.setClient(clientById);

        List<ArticleSimpleResponseDto> listArticleDto = articles.stream().map(article -> new ArticleSimpleResponseDto(article.getId(), article.getLibelle())).toList();
        model.addAttribute("articleSelectForm", listArticleDto);
        model.addAttribute("panier", panier);
        return "Commande/form-add-commande";
    }

    @Override
    public String saveCommande() {
        return null;
    }


}
