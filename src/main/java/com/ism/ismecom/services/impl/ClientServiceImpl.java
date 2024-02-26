package com.ism.ismecom.services.impl;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public Page<Client> getAllClientsActive(Pageable pageable) {
        return clientRepository.findAllByActiveTrue(pageable);
    }

    @Override
    public Page<Client> getClientsWithPaginateAndFilter(Pageable pageable, String telephone) {
        System.out.println(clientRepository.findAllByTelephoneContainsAndActiveTrue(pageable,telephone));
        return clientRepository.findAllByTelephoneContainsAndActiveTrue(pageable,telephone);

    }

    @Override
    public List<Client> getClientById(Long id) {
        return clientRepository.findClientById(id);
    }


}
