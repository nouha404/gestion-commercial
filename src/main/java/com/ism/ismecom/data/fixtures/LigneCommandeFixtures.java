package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.entities.LigneCommande;
import com.ism.ismecom.data.repositories.ArticleRepository;
import com.ism.ismecom.data.repositories.CommandeRepository;
import com.ism.ismecom.data.repositories.LigneCommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;


//@DependsOn({"ArticleFixtures", "CommandeFixtures"})
@RequiredArgsConstructor
//@Component
public class LigneCommandeFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final LigneCommandeRepository ligneCommandeRepository;
    private final ArticleRepository articleRepository;
    private final CommandeRepository commandeRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setActive(i%2==0);
            ligneCommande.setPrix(5+i+000.0+i);
            ligneCommande.setQuantite(1+i+0+i+0.+i+1);

            ligneCommande.setMontant(ligneCommande.getPrix()*ligneCommande.getQuantite());

            //Recherche de l'article
            Article article = articleRepository.findById((long) i).orElse(null);
            ligneCommande.setArticle(article);

            //Recherche dela commande
            Commande commande = commandeRepository.findById((long) i).orElse(null);
            ligneCommande.setCommande(commande);
            //insert
            ligneCommandeRepository.save(ligneCommande);
        }
    }
}