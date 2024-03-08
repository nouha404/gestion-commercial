package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Adresse;
import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.security.controllers.Security;
import com.ism.ismecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE - 3)
@RequiredArgsConstructor
//@Component
public class ClientFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 21L; i++) {
            Client client = new Client();
            client.setActive(i%2==0);
            client.setNomComplet("Client "+i);
            if(i<10){
                client.setTelephone("77123567"+i);
            } else {
                client.setTelephone("7712356"+i);
            }
            //L'adresse
            Adresse adresse = new Adresse();
            adresse.setNumVilla("Villa 0"+i+"0"+i);
            adresse.setVille(i%2==0? "Dakar" : "Mbour");
            adresse.setQuartier("Quartier 0"+i+"0"+i);
            client.setAdresse(adresse);

            client.setPassword(passwordEncoder.encode("nouha12b"));
            client.setUsername(client.getNomComplet().toLowerCase());

            //insert sprint data
            clientRepository.save(client);
            // role
            securityService.addRoleToUser(client.getUsername().toLowerCase(),"Client");
        }
    }
}
