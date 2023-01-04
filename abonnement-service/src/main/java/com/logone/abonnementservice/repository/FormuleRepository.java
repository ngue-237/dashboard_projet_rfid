package com.logone.abonnementservice.repository;

import com.logone.abonnementservice.entity.Formule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormuleRepository extends JpaRepository<Formule, Long> {
    Formule findByFormuleName(String formuleName);
}
