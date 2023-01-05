package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;
import com.logone.abonnementservice.entity.Formule;
import com.logone.abonnementservice.mappers.FormuleMapper;
import com.logone.abonnementservice.repository.FormuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormuleServiceImpl implements FormuleService {
    private FormuleMapper formuleMapper;
    private FormuleRepository formuleRepository;

    public FormuleServiceImpl(FormuleMapper formuleMapper, FormuleRepository formuleRepository) {
        this.formuleMapper = formuleMapper;
        this.formuleRepository = formuleRepository;
    }

    @Override
    public FormuleResponseDTO saveNewFormule(FormuleRequestDTO formuleRequestDTO) {
        Formule formule = this.formuleMapper.fromFormuleRequestDTO(formuleRequestDTO);
        
        return this.formuleMapper.fromFormule(this.formuleRepository.save(formule));
    }

    @Override
    public FormuleResponseDTO getFormuleByFormuneName(String formuleName) {
        return this.formuleMapper.fromFormule(this.formuleRepository.findByFormuleName(formuleName));
    }

    @Override
    public void deleteFormuleById(Long id) {
        this.formuleRepository.deleteById(id);
    }


    @Override
    public List<FormuleResponseDTO> getAllFormules() {
        List<Formule> formules = this.formuleRepository.findAll();
        return formules.stream()
                .map(formule -> this.formuleMapper.fromFormule(formule))
                .collect(Collectors.toList());
    }
}
