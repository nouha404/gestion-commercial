package com.ism.ismecom.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    // il va chercher la classe qui implement cette interface et il va aller chercher la methode loadByUsername
    private final UserDetailsService service;
    // decrypter le password
    private final PasswordEncoder passwordEncoder;

    // methode authentication dire où se trouvent les données et apres ou il doit mettre les données
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(service);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    // Authorisation
    @Bean // creer au démarrage
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        // HttpSecurity contient la requete
        http.formLogin(httpSecurityFormLoginConfigurer -> {
            // les requetes qu'on laisse passer
            httpSecurityFormLoginConfigurer.loginPage("/login")
                    .permitAll()
        }).authorizeHttpRequests(
                // les autorisations idem
                auth -> {

                }
        );
         return http.build();
    }


}
