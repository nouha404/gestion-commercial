package com.ism.ismecom.web.dto.response;

import com.ism.ismecom.data.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientShowEntityResponseDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String quartier;
    private String numVilla;
    private String adresseComplet;


    private void adresseComplet(){
        adresseComplet =  String.format("%s %s", quartier,numVilla);
    }

    //transformer le type client en un type dto => mapper sans builder
    public static ClientShowEntityResponseDto toDto(Client client){
        ClientShowEntityResponseDto clientShowEntityResponseDto = new ClientShowEntityResponseDto(
                client.getId(),
                client.getNomComplet(),
                client.getTelephone(),
                client.getAdresse().getQuartier(),
                client.getAdresse().getNumVilla(),null
        );
        clientShowEntityResponseDto.adresseComplet();
        return clientShowEntityResponseDto;

    }


}


