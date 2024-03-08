package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.services.ClientService;
import com.ism.ismecom.web.controllers.ClientController;
import com.ism.ismecom.web.dto.request.CreateClientRequestDto;
import com.ism.ismecom.web.dto.request.PanierDto;
import com.ism.ismecom.web.dto.response.ClientShowEntityResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class ClientControllerImpl implements ClientController {
    //injection par contructeur
    private  final ClientService clientService;

    @Override
    public String listerClient(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5",name = "size") int size,
            @RequestParam(defaultValue = "",name = "telephone") String telephone,
            @ModelAttribute("panier") PanierDto panier
    ) {

        //initialiser le panier mettre le total aussi a 0
        panier.getArticlesPanier().clear();
        panier.setTotal(0);
        //formulaire
        Page<Client> clients = clientService.getClientsWithPaginateAndFilter(PageRequest.of(page,size),telephone);
        //transformer objet type client => clientDto
        Page<ClientShowEntityResponseDto> clientsDto = clients.map(ClientShowEntityResponseDto::toDto);



        model.addAttribute("clients",clientsDto.getContent());
        //mettre le numero dans le placeholder ou le value du formulaire
        model.addAttribute("telephone", telephone);
        //creer un tableau pour le nombre de pages
        model.addAttribute("pages",new int[clientsDto.getTotalPages()]);
        //position de la page
        model.addAttribute("currentPage",page);

        //next page : verifie si page est < nombre total de pages disponibles
        model.addAttribute("nextPage", page < clients.getTotalPages() - 1 ? page+1:page);
        //previous page idem
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);
        return "Client/client";
    }

    @Override
    public String showForm(Model model) {
        //Mapper le dto creer pour le formulaire Avec builder
        //CreateClientRequestDto clientCreateRequestDto = new CreateClientRequestDto();
        CreateClientRequestDto clientCreateRequestDto = CreateClientRequestDto.builder().build();
        model.addAttribute("client",clientCreateRequestDto);
        return "Client/form-add-client";
    }

    //creer le panier au démarrage
    @ModelAttribute("panier")
    public PanierDto panier(){return new PanierDto(
            new ArrayList<>(),0,null);
    }

    //a faire
    @Override
    public String saveClient(
            @Valid CreateClientRequestDto clientDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            //maintenant parcourir et les transformer en map
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(
                    fieldError.getField(), fieldError.getDefaultMessage())
            );
            //mettre les erreurs dans la view
            redirectAttributes.addFlashAttribute("mode", "error");
            redirectAttributes.addFlashAttribute("errors", errors);

            redirectAttributes.addFlashAttribute("nomComplet", clientDto.getNomComplet());
            redirectAttributes.addFlashAttribute("telephone", clientDto.getTelephone());
            redirectAttributes.addFlashAttribute("quartier", clientDto.getQuartier());
            redirectAttributes.addFlashAttribute("numVilla", clientDto.getNumVilla());
            redirectAttributes.addFlashAttribute("ville", clientDto.getVille());
        } else {
            clientService.addClient(clientDto);
            System.out.println(clientDto.getNomComplet());
        }
        return "redirect:/show-client-form";

    }


}
