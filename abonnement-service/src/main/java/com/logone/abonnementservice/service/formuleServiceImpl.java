package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;
import com.logone.abonnementservice.entity.Formule;
import com.logone.abonnementservice.mappers.FormuleMapper;
import com.logone.abonnementservice.repository.FormuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class formuleServiceImpl implements formuleService {
    private FormuleMapper formuleMapper;
    private FormuleRepository formuleRepository;

    public formuleServiceImpl(FormuleMapper formuleMapper, FormuleRepository formuleRepository) {
        this.formuleMapper = formuleMapper;
        this.formuleRepository = formuleRepository;
    }

    @Override
    public FormuleResponseDTO saveNewFormule(FormuleRequestDTO formuleRequestDTO) {
        Formule formule = this.formuleMapper.fromFormuleRequestDTO(formuleRequestDTO);
        Formule formuleSaved = this.formuleRepository.save(formule);
        
        return this.formuleMapper.fromFormule(formuleSaved);
    }

    @Override
    public FormuleRequestDTO getFormuleByFormuneName(String formuleName) {
        return null;
    }

    @Override
    public Void deleteFormuleById(Long id) {
        return null;
    }

    @Override
    public List<FormuleResponseDTO> getAllFormules() {
        return null;
    }
}
