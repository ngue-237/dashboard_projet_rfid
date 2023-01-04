package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;

import java.util.List;

public interface formuleService {
    FormuleResponseDTO saveNewFormule(FormuleRequestDTO formuleRequestDTO);
    FormuleRequestDTO getFormuleByFormuneName(String formuleName);
    Void deleteFormuleById(Long id);
    List<FormuleResponseDTO> getAllFormules();
}
