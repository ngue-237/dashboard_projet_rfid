package com.logone.abonnementservice.mappers;

import com.logone.abonnementservice.dto.AbonnementRequestDTO;
import com.logone.abonnementservice.dto.AbonnementResponseDTO;
import com.logone.abonnementservice.entity.Abonnement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbonnementMapper {
    AbonnementResponseDTO fromAbonnement(Abonnement abonnement);
    Abonnement fromAbonnementRequest(AbonnementRequestDTO abonnementRequestDTO);
}
