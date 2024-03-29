package com.ism.ismecom.data.entities;

import com.ism.ismecom.security.data.entities.AppUser;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "clients")
@Builder
@DiscriminatorValue(value="Client")
public class Client extends AppUser {
    @Column(nullable = false,length = 50)
    private String nomComplet;
    @Column(nullable = false,length = 20)
    private String telephone;
    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Commande> commandes;
}
