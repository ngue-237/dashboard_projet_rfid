package com.logone.abonneservice.service;

import com.logone.abonneservice.dto.AbonneRequestDTO;
import com.logone.abonneservice.dto.AbonneResponseDTO;
import com.logone.abonneservice.entity.Abonne;
import com.logone.abonneservice.mappers.AbonneMapper;
import com.logone.abonneservice.model.Abonnement;
import com.logone.abonneservice.repository.AbonneRepository;
import com.logone.abonneservice.restclient.AbonnementRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class AbonneServiceImpl implements AbonneService {
   private AbonneMapper abonneMapper;
   private AbonneRepository abonneRepository;
   private AbonnementRestClient abonnementRestClient;

    public AbonneServiceImpl(AbonneMapper abonneMapper, AbonneRepository abonneRepository, AbonnementRestClient abonnementRestClient) {
        this.abonneMapper = abonneMapper;
        this.abonneRepository = abonneRepository;
        this.abonnementRestClient = abonnementRestClient;
    }

    @Override
    public AbonneResponseDTO saveNewAbonne(AbonneRequestDTO abonneRequestDTO) {
        Abonne abonne = this.abonneMapper.fromAbonneRequest(abonneRequestDTO);
        Abonnement abonnement = this.abonnementRestClient.getAbonnement(abonne.getAbonnementId());
        abonne.setAbonnement(abonnement);
        ///log.error("abonne {}", abonneRequestDTO);
        return this.abonneMapper.fromAbonne(this.abonneRepository.save(abonne));
    }

    @Override
    public AbonneResponseDTO getAbonneById(Long id) {
        Abonne abonne = this.abonneRepository.findById(id).get();
        Abonnement abonnement = this.abonnementRestClient.getAbonnement(abonne.getAbonnementId());
        abonne.setAbonnement(abonnement);
        return this.abonneMapper.fromAbonne(abonne);
    }

    @Override
    public Boolean abonneExist(String rfid) {
        return this.abonneRepository.existsByRfid(rfid);
    }

    @Override
    public List<AbonneResponseDTO> getAllAbonne() {
        List<Abonne> abonnes = this.abonneRepository.findAll();
        for(Abonne abonne:abonnes){
            Abonnement abonnement =this.abonnementRestClient.getAbonnement(abonne.getAbonnementId());
            abonne.setAbonnement(abonnement);
        }
        return abonnes.stream()
                .map(abonne -> this.abonneMapper.fromAbonne(abonne))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAbonneByRfid(String rfid) {
        this.abonneRepository.deleteByRfid(rfid);
    }
}
