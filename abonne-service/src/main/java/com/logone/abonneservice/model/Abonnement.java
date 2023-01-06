package com.logone.abonneservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Abonnement {
    private Long id;
    private String typeAbon;
}
