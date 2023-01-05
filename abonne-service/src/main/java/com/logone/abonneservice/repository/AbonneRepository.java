package com.logone.abonneservice.repository;

import com.logone.abonneservice.entity.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends JpaRepository<Abonne,Long> {
    Boolean existsByRfid(String rfid);
    void deleteByRfid(String rfid);
}
