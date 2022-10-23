package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.MedicalAid;
import za.ac.cput.factory.MedicalAidFactory;
import za.ac.cput.service.MedicalAidService;

import java.util.Optional;
import java.util.Set;
/*
    MedicalAidController.java
    Controller for the Medical Aid .
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@RestController
@RequestMapping("hospital-system/medicalaid/")
@Slf4j
public class MedicalAidController {
    private final MedicalAidService medicalAidService;

    @Autowired
    public MedicalAidController(MedicalAidService medicalAidService) {
        this.medicalAidService = medicalAidService;
    }

    @PostMapping("save")
    public ResponseEntity<MedicalAid> save(@RequestBody MedicalAid medicalAid) {
        log.info("Save request: {}", medicalAid);
        MedicalAid validatedMedicalAid;
        try {
            validatedMedicalAid = MedicalAidFactory.createMedicalAid(medicalAid.getMedicalNum(), medicalAid.getMedicalName(), medicalAid.getMedicAddr());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        MedicalAid save = medicalAidService.save(validatedMedicalAid);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.medicalAidService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Optional<MedicalAid>> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Optional<MedicalAid> medicalAid = this.medicalAidService.read(id);
        return ResponseEntity.ok(medicalAid);
    }

    @GetMapping("all")
    public ResponseEntity<Set<MedicalAid>> findAll() {
        Set<MedicalAid> medicalAids = this.medicalAidService.getAll();
        return ResponseEntity.ok(medicalAids);
    }

}
