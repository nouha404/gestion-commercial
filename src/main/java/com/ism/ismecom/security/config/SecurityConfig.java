package com.ism.ismecom.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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

    // Authorisation a moment ou l'authentification est correcte
    @Bean // creer au démarrage
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http contient la requete
        return http.csrf(AbstractHttpConfigurer::disable)
            /*avec le tempplate
            .formLogin(form ->form // les requetes qu'on laisse passer
                             .loginPage("/login")
                             .permitAll()
            ).authorizeHttpRequests( auth -> auth
                                            .anyRequest()
                                            .authenticated()
                                    )
            .build();*/

            // le template de base
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
            ).authorizeHttpRequests( auth -> auth
                    .requestMatchers("/admin/**").hasAuthority("Admin")
                    .requestMatchers("/client/**").hasAuthority("Client")
                    .anyRequest()
                    .authenticated()
            )
            .build();

    }


}
