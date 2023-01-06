package com.logone.abonneservice.dto;

import com.logone.abonneservice.model.Abonnement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonneResponseDTO {
    private Long id;
    private String rfid;
    private Abonnement abonnement;

}
