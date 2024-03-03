package com.ism.ismecom.data.entities;

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
@Table(name = "categories")
public class Categorie extends AbstractEntity{
    @Column(unique = true,nullable = false,length = 50)
    private String libelle;

    @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    private List<Article> articles;

}
