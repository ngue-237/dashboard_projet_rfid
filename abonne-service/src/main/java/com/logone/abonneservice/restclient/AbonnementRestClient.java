package com.logone.abonneservice.restclient;

import com.logone.abonneservice.model.Abonnement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ABONNEMENT-SERVICE")
public interface AbonnementRestClient {
    @GetMapping(path = "/api/abonnement-service/{id}")
    Abonnement getAbonnement(@PathVariable(name = "id") Long id);
    @GetMapping(path = "/api/abonnement-service/all")
    List<Abonnement> getAllAbonnement();

}
