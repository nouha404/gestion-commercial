package com.ism.ismecom.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientController {
    @GetMapping("/liste-client")
    String listerClient(Model model,
                        @RequestParam(defaultValue = "0",name = "page") int page,
                        @RequestParam(defaultValue = "8",name = "size") int size,
                        @RequestParam(defaultValue = "",name = "telephone") String telephone
                        );




}
