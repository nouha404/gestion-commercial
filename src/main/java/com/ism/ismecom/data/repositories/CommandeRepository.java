package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
