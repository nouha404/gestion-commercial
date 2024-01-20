package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Categorie;
import com.ism.ismecom.data.repositories.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@Component
public class CategorieFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final CategorieRepository categorieRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Categorie categorie = new Categorie();
            categorie.setLibelle("Categ "+i);
            categorie.setActive(i%2==0);
            //insert
            categorieRepository.save(categorie);

        }
    }
}
