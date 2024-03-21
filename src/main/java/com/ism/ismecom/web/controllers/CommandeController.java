package com.ism.ismecom.web.controllers;

import com.ism.ismecom.web.dto.request.CreateClientRequestDto;
import com.ism.ismecom.web.dto.request.PanierDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CommandeController {
    @GetMapping("/admin/liste-commande")
    String listeCommande(Model model,
                         @RequestParam(defaultValue = "0",name = "page") int page,
                         @RequestParam(defaultValue = "5",name = "size") int size,
                         @RequestParam(name="id") long id

    );

    @GetMapping("/admin/liste-all-cmde")
    public String listerAllCommande(Model model,
                                    @RequestParam(defaultValue = "0",name = "page") int page,
                                    @RequestParam(defaultValue = "5",name = "size") int size
    );

    @GetMapping("/admin/show-commande-form")
    String showFormCommande(
            Model model,
            @RequestParam(name="id") long id,
            @ModelAttribute("panier") PanierDto panier
    );

    @GetMapping("/admin/save-commande")
    String saveCommande(
            Model model,
            @ModelAttribute("panier") PanierDto panier

    );


}
