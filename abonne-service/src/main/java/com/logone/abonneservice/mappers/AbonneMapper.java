package com.logone.abonneservice.mappers;

import com.logone.abonneservice.dto.AbonneRequestDTO;
import com.logone.abonneservice.dto.AbonneResponseDTO;
import com.logone.abonneservice.entity.Abonne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbonneMapper {
    Abonne fromAbonneRequest(AbonneRequestDTO abonneRequestDTO);
    AbonneResponseDTO fromAbonne(Abonne abonne);

}
