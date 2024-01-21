package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findAllByActive(Boolean active);

    List<Client> findAllByActiveTrue();
    Page<Client> findAllByActiveTrue(Pageable pageable);
    List<Client> findClientById(Long id);

    //Client findClientById(int id);


}
