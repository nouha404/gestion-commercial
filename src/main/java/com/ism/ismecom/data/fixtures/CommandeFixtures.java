package com.ism.ismecom.data.fixtures;

import com.ism.ismecom.data.entities.Adresse;
import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.enums.EtatCommande;
import com.ism.ismecom.data.repositories.ClientRepository;
import com.ism.ismecom.data.repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Order(Ordered.LOWEST_PRECEDENCE - 4)
@RequiredArgsConstructor
//@Component
public class CommandeFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 21L; i++) {
            Commande commande = new Commande();
            commande.setActive(i%2==0);
            //L'adresse
            Adresse adresse = new Adresse();
            adresse.setNumVilla("Villa 0" + i + "0" + i);
            adresse.setVille(i % 2 == 0 ? "Dakar" : "Mbour");
            adresse.setQuartier("Quartier 0" + i + "0" + i);

            commande.setAdresse(adresse);

            //recherche le client
            Client client = clientRepository.findById(i).orElse(null) ;
            commande.setClient(client);

            // Date avec le jour incrémenté
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, (int) i);
            Date incrementedDate = calendar.getTime();
            // Formattage de la date en "yyyy-MM-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(incrementedDate);

            commande.setDateCommand(java.sql.Date.valueOf(formattedDate));

            //generer a partir des enumerations
            EtatCommande etatCommande = EtatCommande.values()[(int) (Math.random() * EtatCommande.values().length)];

            commande.setEtat(etatCommande);
            commande.setMontant(500+i+.0+i+10);

            //insert
            commandeRepository.save(commande);
            
        }
    }
}
