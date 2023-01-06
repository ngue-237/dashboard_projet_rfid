package com.logone.abonneservice.api;

import com.logone.abonneservice.dto.AbonneRequestDTO;
import com.logone.abonneservice.dto.AbonneResponseDTO;
import com.logone.abonneservice.service.AbonneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/abonne-service")
@Slf4j
public class AbonneController {

    private AbonneService abonneService;


    public AbonneController(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @PostMapping("/add")
    public ResponseEntity<AbonneResponseDTO> addNewAbonne(@RequestBody AbonneRequestDTO abonneRequestDTO){
        log.error("AbonneRequest {}", abonneRequestDTO);
    return ResponseEntity.ok().body(this.abonneService.saveNewAbonne(abonneRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbonneResponseDTO> getAbonneById(@PathVariable(name = "id")  Long id)
    {
        return ResponseEntity.ok().body(this.abonneService.getAbonneById(id));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<AbonneResponseDTO>> listAllAbonne(){
        return ResponseEntity.ok().body(this.abonneService.getAllAbonne());
    }

}
