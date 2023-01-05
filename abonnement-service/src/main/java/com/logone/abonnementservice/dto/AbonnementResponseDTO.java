package com.logone.abonnementservice.dto;

import com.logone.abonnementservice.entity.Formule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonnementResponseDTO {
    private Long id;
    private String typeAbon;
    private Formule formule;
}
