package com.ism.ismecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients")
public class Client extends AbstractEntity {
    @Column(nullable = false,length = 50)
    private String nomComplet;
    @Column(nullable = false,length = 20)
    private String telephone;
    @Embedded
    private Adresse adresse;
}