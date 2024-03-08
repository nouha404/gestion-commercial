package com.ism.ismecom.security.data.fixtures;

import com.ism.ismecom.data.entities.Categorie;
import com.ism.ismecom.data.repositories.CategorieRepository;
import com.ism.ismecom.security.data.entities.AppRole;
import com.ism.ismecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class AppRoleFixtures implements CommandLineRunner {
    //injection de dependance avec @RequiredArgsConstructor
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        securityService.saveRole("Admin");
        securityService.saveRole("Client");
    }
}
