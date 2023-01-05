package com.logone.abonnementservice.api;

import com.logone.abonnementservice.dto.FormuleRequestDTO;
import com.logone.abonnementservice.dto.FormuleResponseDTO;
import com.logone.abonnementservice.service.FormuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/abonnement-service")
public class FormuleController {
    private FormuleService formuleService;

    public FormuleController(FormuleService formuleService) {
        this.formuleService = formuleService;
    }

    @PostMapping("/add-formule")
    public ResponseEntity<FormuleResponseDTO> addNewFormule(@RequestBody FormuleRequestDTO formuleRequestDTO){
        return  ResponseEntity.ok().body(this.formuleService.saveNewFormule(formuleRequestDTO));
    }
    @GetMapping("get-formule")
    public ResponseEntity<FormuleResponseDTO> listFormuleByFormuleName(@PathVariable String formuleName){
        return ResponseEntity.ok().body(this.formuleService.getFormuleByFormuneName(formuleName));
    }

    @GetMapping("/get-all-formules")
    public ResponseEntity<List<FormuleResponseDTO>> listAllFormule(){
        return  ResponseEntity.ok().body(this.formuleService.getAllFormules());
    }

    @DeleteMapping("/delete-formule/{id}")
    public ResponseEntity<String> deleteFormule(@PathVariable(name = "id") Long idFormule){
        return ResponseEntity.ok().body("formule delete successfully");
    }
}
