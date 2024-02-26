package com.ism.ismecom.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
