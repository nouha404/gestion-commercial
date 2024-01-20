package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
