package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@Component
public class ArticleFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final ArticleRepository articleRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
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

            //insert
            articleRepository.save(article);
        }
    }
}
