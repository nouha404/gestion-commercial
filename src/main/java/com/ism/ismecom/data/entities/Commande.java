package com.ism.ismecom.data.entities;

import com.ism.ismecom.data.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "commandes")
public class Commande extends AbstractEntity{
    @Column(unique = false,nullable = true,length = 50)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCommand;
    private Double montant;
    @Enumerated(value = EnumType.STRING)
    private EtatCommande etat;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;
}
