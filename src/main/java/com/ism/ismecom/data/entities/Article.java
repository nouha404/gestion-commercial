package com.ism.ismecom.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "articles")
public class Article extends AbstractEntity{
    @Column(unique = true,nullable = false,length = 50)
    private String libelle;
    private Double ancienPrix;
    private Double nouveauPrix;
    private Boolean promo;
    private Double qteStock;
    private String photo;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommande;

    @ManyToOne
    Categorie categorie;
}
