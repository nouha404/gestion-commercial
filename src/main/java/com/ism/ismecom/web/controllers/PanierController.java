package com.ism.ismecom.web.controllers;

import org.springframework.ui.Model;
import com.ism.ismecom.web.dto.request.ArticlePanierDto;
import com.ism.ismecom.web.dto.request.PanierDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface PanierController {
    @PostMapping("/add-panier")
    String AddProduitPanier(
            Model model,
            @Valid ArticlePanierDto articleForm,
            @ModelAttribute("panier") PanierDto panier,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
            );
}
