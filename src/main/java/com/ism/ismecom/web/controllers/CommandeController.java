package com.ism.ismecom.web.controllers;

import com.ism.ismecom.web.dto.request.CreateClientRequestDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CommandeController {
    @GetMapping("/liste-commande")
    String listeCommande(Model model,
                         @RequestParam(defaultValue = "0",name = "page") int page,
                         @RequestParam(defaultValue = "5",name = "size") int size,
                         @RequestParam(name="id") long id

    );

    @GetMapping("/liste-all-cmde")
    public String listerAllCommande(Model model,
                                    @RequestParam(defaultValue = "0",name = "page") int page,
                                    @RequestParam(defaultValue = "5",name = "size") int size
    );

    @GetMapping("/show-commande-form")
    String showFormCommande(
            Model model,
            @RequestParam(name="id") long id
    );

    @PostMapping("/save-commande")
    String saveCommande(

    );
}
