package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Page<Client> findAllByActiveTrue(Pageable pageable);
    Page<Client> findAllByTelephoneContainsAndActiveTrue(Pageable pageable,String telephone);

    //Pour le test dans la console
    List<Client> findAllByActiveTrue();
    List<Client> findClientById(Long id);

    Page<Client> findClientById(Pageable pageable,Long id);


    //Page<Client> findClientById(Long id);
    //Client findClientById(int id);


}
