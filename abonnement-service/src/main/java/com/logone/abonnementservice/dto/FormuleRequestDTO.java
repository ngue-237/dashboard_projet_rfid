package com.logone.abonnementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormuleRequestDTO {
    private String formuleName;
    private int nbPoints;
    private String description;
}
