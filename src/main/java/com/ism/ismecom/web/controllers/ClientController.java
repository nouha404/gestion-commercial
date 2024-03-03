package com.ism.ismecom.web.controllers;

import com.ism.ismecom.web.dto.request.CreateClientRequestDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ClientController {
    @GetMapping("/liste-client")
    String listerClient(Model model,
                        @RequestParam(defaultValue = "0",name = "page") int page,
                        @RequestParam(defaultValue = "8",name = "size") int size,
                        @RequestParam(defaultValue = "",name = "telephone") String telephone
                        );


    @GetMapping("/show-client-form")
    String showForm(Model model);

    @PostMapping("/save-client")
    String saveClient(
                      CreateClientRequestDto clientDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes
    );

}
