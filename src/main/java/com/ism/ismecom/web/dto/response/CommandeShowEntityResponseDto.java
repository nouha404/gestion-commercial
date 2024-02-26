package com.ism.ismecom.web.dto.response;

import com.ism.ismecom.data.entities.Adresse;
import com.ism.ismecom.data.entities.Commande;
import com.ism.ismecom.data.enums.EtatCommande;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeShowEntityResponseDto {
    private Date dateCommand;
    private Double montant;
    private EtatCommande etat;
    private EtatCommande etatSuivant;
    private Adresse adresse;
    private Long id;

    //transformer le type client en un type dto => mapper avec builder
    public static CommandeShowEntityResponseDto toDto(Commande commande){
        //rendre etat suivant dynamique dans la view
        EtatCommande EtatSuivant = EtatCommande.Payer;
        if(commande.getEtat() != EtatCommande.Payer){
            long indexEnumEtat = commande.getEtat().getIndexEnumEtat()+1;
            EtatSuivant = EtatCommande.values()[Long.valueOf(indexEnumEtat).intValue()];

        }
        return CommandeShowEntityResponseDto
                .builder()
                .id(commande.getId())
                .dateCommand(commande.getDateCommand())
                .montant(commande.getMontant())
                .etat(commande.getEtat())
                .etatSuivant(EtatSuivant)
                .adresse(commande.getAdresse())
                .build();
    }
}
