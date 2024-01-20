package com.ism.ismecom.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatCommande {
    Encours(0),
    Terminer(1),
    Facturer(2),
    Payer(3);
    private final long indexEnumEtat;

}
