package com.logone.abonnementservice.repository;

import com.logone.abonnementservice.entity.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
}
