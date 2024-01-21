package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Categorie;
import com.ism.ismecom.data.repositories.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE - 1)
@RequiredArgsConstructor
//@Component
public class CategorieFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final CategorieRepository categorieRepository;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 21L; i++) {
            Categorie categorie = new Categorie();
            categorie.setLibelle("Categ "+i);
            categorie.setActive(i%2==0);
            //insert
            categorieRepository.save(categorie);

        }
    }
}
