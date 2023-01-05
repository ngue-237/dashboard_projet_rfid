package com.logone.abonnementservice.api;

import com.logone.abonnementservice.dto.AbonnementRequestDTO;
import com.logone.abonnementservice.dto.AbonnementResponseDTO;
import com.logone.abonnementservice.service.AbonnementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonnement-service")
public class AbonnementController {
    private AbonnementService abonnementService;

    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @PostMapping("/add")
    public ResponseEntity<AbonnementResponseDTO> addNewAbonnement(@RequestBody AbonnementRequestDTO abonnementRequestDTO){
        return  ResponseEntity.ok().body(this.abonnementService.addNewAbonnement(abonnementRequestDTO));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AbonnementResponseDTO> getAbonnement(@PathVariable(name = "id") Long idAbon){
        return ResponseEntity.ok().body(this.abonnementService.getAbonnement(idAbon));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AbonnementResponseDTO>> getAllAbonnement(){
        return ResponseEntity.ok().body(this.abonnementService.getAllAbonnements());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAbonnement(Long id){
        return ResponseEntity.ok().body("delete successfully");
    }
}
