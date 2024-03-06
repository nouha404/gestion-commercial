package com.ism.ismecom.web.controllers.impl;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.repositories.ArticleRepository;
import org.springframework.ui.Model;
import com.ism.ismecom.web.controllers.PanierController;
import com.ism.ismecom.web.dto.request.ArticlePanierDto;
import com.ism.ismecom.web.dto.request.PanierDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class PanierControllerImpl implements PanierController {
    private final ArticleRepository articleRepository;

    @Override
    public String AddProduitPanier(Model model,
                                   ArticlePanierDto articleForm,
                                   PanierDto panier,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes
    ) {
        //validation a faire

        /* if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(
                    fieldError.getField(), fieldError.getDefaultMessage())
            );
            //mettre les erreurs dans la view
            redirectAttributes.addFlashAttribute("mode", "error");
            redirectAttributes.addFlashAttribute("errors", errors);
        } else {
            System.out.println("clientDto.getNomComplet()");
        }*/
        //recuperer le libelle de l'article et le metre dans le panier
        Article article = articleRepository.findById(articleForm.getId()).orElse(null);
        if(article!=null){
            articleForm.setPrix(articleForm.getPrix()==null?article.getNouveauPrix():articleForm.getPrix());
            articleForm.setLibelle(article.getLibelle());
            //panier.getArticlesPanier().add(articleForm);
            panier.addArticleToPanier(articleForm);
        }

        //model.addAttribute("panier", panier);
        return "redirect:/show-commande-form?id=" + panier.getClient().getId();


    }
}
