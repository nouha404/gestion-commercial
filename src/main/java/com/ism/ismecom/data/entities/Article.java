package com.ism.ismecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article extends AbstractEntity{
    @Column(unique = true,nullable = false,length = 50)
    private String libelle;
    private Double ancienPrix;
    private Double nouveauPrix;
    private Boolean promo;
    private Double qteStock;
    private String photo;
    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommande;
}
