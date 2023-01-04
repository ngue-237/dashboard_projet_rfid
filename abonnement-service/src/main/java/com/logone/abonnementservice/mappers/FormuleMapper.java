package com.logone.abonnementservice.mappers;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;
import com.logone.abonnementservice.entity.Formule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormuleMapper {
    Formule fromFormuleRequestDTO(FormuleRequestDTO formuleRequestDTO);
    FormuleResponseDTO fromFormule(Formule formule);
}
