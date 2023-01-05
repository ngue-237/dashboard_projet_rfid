package com.logone.abonnementservice.service;

import com.logone.abonnementservice.dto.AbonnementRequestDTO;
import com.logone.abonnementservice.dto.AbonnementResponseDTO;
import com.logone.abonnementservice.entity.Abonnement;
import com.logone.abonnementservice.entity.Formule;
import com.logone.abonnementservice.mappers.AbonnementMapper;
import com.logone.abonnementservice.repository.AbonnementRepository;
import com.logone.abonnementservice.repository.FormuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
@Transactional
public class AbonnementServiceImpl implements AbonnementService {
    private AbonnementMapper abonnementMapper;
    private AbonnementRepository abonnementRepository;
    private FormuleRepository formuleRepository;

    public AbonnementServiceImpl(AbonnementMapper abonnementMapper, AbonnementRepository abonnementRepository, FormuleRepository formuleRepository) {
        this.abonnementMapper = abonnementMapper;
        this.abonnementRepository = abonnementRepository;
        this.formuleRepository = formuleRepository;
    }

    @Override
    public AbonnementResponseDTO addNewAbonnement(AbonnementRequestDTO abonnementRequestDTO) {
        Abonnement abonnement = this.abonnementMapper.fromAbonnementRequest(abonnementRequestDTO);
        log.info("request {}", abonnementRequestDTO);
        abonnement.setDateDeb(new Date());
        Formule formule = this.formuleRepository.findById(abonnementRequestDTO.getFormuleID()).get();
        abonnement.setFormule(formule);
        Abonnement abonnementSaved = this.abonnementRepository.save(abonnement);
        return this.abonnementMapper.fromAbonnement(abonnementSaved);
    }

    @Override
    public AbonnementResponseDTO getAbonnement(Long idAbonnement) {

        return this.abonnementMapper.fromAbonnement(this.abonnementRepository.findById(idAbonnement).get());
    }

    @Override
    public List<AbonnementResponseDTO> getAllAbonnements() {
        List<Abonnement> abonnements = this.abonnementRepository.findAll();

        return abonnements.stream()
                .map(abonnement -> this.abonnementMapper.fromAbonnement(abonnement))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAbonnement(Long id) {
        this.abonnementRepository.deleteById(id);
    }
}
