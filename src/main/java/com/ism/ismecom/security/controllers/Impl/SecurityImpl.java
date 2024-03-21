package com.ism.ismecom.security.controllers.Impl;

import com.ism.ismecom.security.controllers.Security;
import com.ism.ismecom.security.data.entities.AppUser;
import com.ism.ismecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    private final SecurityService securityService;
    @Override
    public String login(@AuthenticationPrincipal UserDetails user) {
        System.out.println(user.getUsername() + " est connecté !");
        // anyMatch dès qu'il trouve un critere valid …
        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("Admin") == 0) ){
            return "redirect:/admin/liste-client";
        }

        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("Client") == 0) ){
            //recuperer le user
            AppUser usr = securityService.getUser(user.getUsername());
            return "redirect:/client/liste-commande?id="+ usr.getId();
        }
        return "redirect:/login";
        // return "Security/login";
    }
}
