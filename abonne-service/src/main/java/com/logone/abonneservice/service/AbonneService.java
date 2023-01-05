package com.logone.abonneservice.service;

import com.logone.abonneservice.dto.AbonneRequestDTO;
import com.logone.abonneservice.dto.AbonneResponseDTO;
import com.logone.abonneservice.entity.Abonne;

import java.util.List;

public interface AbonneService {
    AbonneResponseDTO saveNewAbonne(AbonneRequestDTO abonneRequestDTO);
    AbonneResponseDTO getAbonneById(Long id);
    Boolean abonneExist(String rfid);
    List<AbonneResponseDTO> getAllAbonne();
    void deleteAbonneByRfid(String rfid);
}
