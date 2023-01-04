package com.logone.abonnementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormuleResponseDTO {
    private Long id;
    private String formuleName;
    private int nbPoints;
    private String description;
}
