package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.AbonnementRequestDTO;
import com.logone.abonnementservice.dto.AbonnementResponseDTO;
import com.logone.abonnementservice.entity.Abonnement;

import java.util.List;

public interface AbonnementService {
    AbonnementResponseDTO addNewAbonnement(AbonnementRequestDTO abonnementRequestDTO);
    AbonnementResponseDTO getAbonnement(Long idAbonnement);
    List<AbonnementResponseDTO> getAllAbonnements();
    void deleteAbonnement(Long id);
}
