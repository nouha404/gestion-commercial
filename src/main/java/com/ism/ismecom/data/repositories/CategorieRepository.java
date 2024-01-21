package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    //Client findClientById(int id);
    //Categorie findById
}
