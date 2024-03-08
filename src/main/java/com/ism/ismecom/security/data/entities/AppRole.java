package com.ism.ismecom.security.data.entities;

import com.ism.ismecom.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "roles")

public class AppRole extends AbstractEntity {
    @Column(unique = true,nullable = true)
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles") //ici on laisse le fetch ease : on ne veut pas au moment ou il charge les roles qu'il charge les users
    List<AppUser> users;

    public AppRole(String roleName) {
        this.roleName = roleName;
    }
}
