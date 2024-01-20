package com.ism.ismecom.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "ligne_commandes")
public class LigneCommande extends AbstractEntity{
    private Double montant;
    private Double quantite;
    private Double prix;
    @ManyToOne
    Article article;
    @ManyToOne
    Commande commande;
}
