package com.ism.ismecom.data.entities;

import jakarta.persistence.*;
import lombok.*;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "ligne_commandes")
public class Adresse{

    private String quartier;
    private String ville;
    private String numVilla;
    @ManyToOne
    Article article;

    @Override
    public String toString() {
        return
                ville + " | " +
                        quartier + " | "+
        numVilla
        ;
    }

}
