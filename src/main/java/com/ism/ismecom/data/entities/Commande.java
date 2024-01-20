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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "commandes")
public class Commande extends AbstractEntity{
    @Column(unique = true,nullable = false,length = 50)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCommand;
    private Double montant;
    @Enumerated(value = EnumType.STRING)
    private EtatCommande etat;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;
}