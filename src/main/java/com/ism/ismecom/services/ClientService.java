package com.ism.ismecom.services;

import com.ism.ismecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Page<Client> getAllClientsActive(Pageable pageable);
    Page<Client> getClientsWithPaginateAndFilter(Pageable pageable,String telephone);
    List<Client> getClientById(Long id);
}
