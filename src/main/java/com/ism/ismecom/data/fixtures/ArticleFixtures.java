package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.entities.Categorie;
import com.ism.ismecom.data.repositories.ArticleRepository;
import com.ism.ismecom.data.repositories.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE - 2)
@RequiredArgsConstructor
//@Component
//@Component
public class ArticleFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 21L; i++) {
            Article article = new Article();
            article.setLibelle("Article 00"+i);
            article.setAncienPrix(5+i+000.0+i);
            article.setPromo(i%2==0);

            if(article.getPromo()){
                article.setNouveauPrix(5+i+000.0+i*0.5);
            } else {
                article.setNouveauPrix(5+i+000.0+i);
            }
            article.setPhoto("photo"+i+".png");
            article.setQteStock(1+i+0+i+0.+i+1);
            article.setActive(i%2==0);

            //recherche de categ
            Categorie categorie = categorieRepository.findById(i).orElse(null);
            article.setCategorie(categorie);

            //insert
            articleRepository.save(article);
        }
    }
}
