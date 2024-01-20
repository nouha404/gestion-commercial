package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Adresse;
import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE - 3)
@RequiredArgsConstructor
//@Component
public class ClientFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final ClientRepository clientRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
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

            //insert sprint data
            clientRepository.save(client);
        }
    }
}
