package com.ism.ismecom.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ligne_commandes")
public class Adresse{

    private String quartier;
    private String ville;
    private String numVilla;
    @ManyToOne
    Article article;

}
