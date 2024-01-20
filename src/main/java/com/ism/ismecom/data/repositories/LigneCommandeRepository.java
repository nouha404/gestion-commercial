package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
