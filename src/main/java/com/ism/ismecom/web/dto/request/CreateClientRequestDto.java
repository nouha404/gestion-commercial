package com.ism.ismecom.web.dto.request;

import com.ism.ismecom.data.entities.Adresse;
import com.ism.ismecom.data.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClientRequestDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String adresse;

    private String quartier;
    private String numVilla;
    private String ville;

    //Mapper
    public  Client TransformToEntity(){
        return Client.builder()
                .nomComplet(nomComplet)
                .telephone(telephone)
                .adresse(new Adresse(quartier,ville,numVilla))
                .build();

    }
}
