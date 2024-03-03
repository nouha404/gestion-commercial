package com.ism.ismecom.data.entities;

import jakarta.persistence.*;
import lombok.*;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "adresses")
public class Adresse{

    private String quartier;
    private String ville;
    private String numVilla;

    @Override
    public String toString() {
        return
                ville + " | " +
                        quartier + " | "+
        numVilla
        ;
    }

}
