package com.ism.ismecom.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlePanierDto {
    private Long id;
    private String libelle;
    private Double montant;
    private Double quantite;
    private Double prix;
}
