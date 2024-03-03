package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.services.ClientService;
import com.ism.ismecom.web.controllers.ClientController;
import com.ism.ismecom.web.dto.request.CreateClientRequestDto;
import com.ism.ismecom.web.dto.response.ClientShowEntityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    //injection par contructeur
    private  final ClientService clientService;

    @Override
    public String listerClient(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5",name = "size") int size,
            @RequestParam(defaultValue = "",name = "telephone") String telephone
    ) {
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

    //a faire
    @Override
    public String saveClient(CreateClientRequestDto clientDto) {
        clientService.addClient(clientDto);
        System.out.println(clientDto.getNomComplet());
        return "redirect:/show-client-form";
    }






}
