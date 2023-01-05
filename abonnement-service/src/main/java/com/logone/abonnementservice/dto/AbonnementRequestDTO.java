package com.logone.abonnementservice.dto;

import com.logone.abonnementservice.entity.Formule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonnementRequestDTO {
    private Long id;
    private String typeAbon;
    private Long formuleID;

}
