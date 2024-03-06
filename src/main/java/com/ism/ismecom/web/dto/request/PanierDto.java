package com.ism.ismecom.web.dto.request;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.web.dto.response.ClientShowEntityResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanierDto {
    private List<ArticlePanierDto> articlesPanier;
    private double total;
    private ClientShowEntityResponseDto client;


    public void addArticleToPanier(ArticlePanierDto article) {
        /*
        Optional<ArticlePanierDto> first = articlesPanier
                .stream()
                .filter(articlePanierDto -> article.getId() == articlePanierDto.getId())
                .findFirst();*/
        int i = articlesPanier.indexOf(article);
        double montant = 0.0;
        if(i!=-1){
            ArticlePanierDto articleGetPanier = articlesPanier.get(i);
            articleGetPanier.calculQte(article.getQuantite());
            articleGetPanier.calculMontant(article.getQuantite()*articleGetPanier.getPrix());
            total=article.getQuantite()*articleGetPanier.getPrix();
        }else{
            article.setMontant(article.getPrix()*article.getQuantite());
            articlesPanier.add(article);
            total+=article.getMontant();
        }

    }



}
