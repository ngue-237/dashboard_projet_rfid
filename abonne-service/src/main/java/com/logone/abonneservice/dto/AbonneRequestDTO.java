package com.logone.abonneservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbonneRequestDTO {
    private Long id;
    private String rfid;
    private Long abonnementId;
}
