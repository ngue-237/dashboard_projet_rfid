package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;

import java.util.List;

public interface FormuleService {
    FormuleResponseDTO saveNewFormule(FormuleRequestDTO formuleRequestDTO);
    FormuleResponseDTO getFormuleByFormuneName(String formuleName);
    void deleteFormuleById(Long id);
    List<FormuleResponseDTO> getAllFormules();
}
