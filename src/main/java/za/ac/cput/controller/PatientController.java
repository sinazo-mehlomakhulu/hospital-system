package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Patient;
import za.ac.cput.service.PatientService;

import javax.validation.Valid;
import java.util.Set;
/*
    Patient.java
    Entity: PatientController
    Author: Ishmail T Mgwena (215088417)
    Date:  20 September 2022
*/
@RestController
@RequestMapping("hospital system/patient/")
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){this.patientService = patientService;}

    @PostMapping("save")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient) {
        log.info("Save request: {}", patient);
        Patient save = patientService.save(patient);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Patient> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Patient patient = this.patientService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(patient);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Patient> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("find-all")
    public ResponseEntity<Set<Patient>> getAll() {
        Set<Patient> patientList = this.patientService.getAll();
        return ResponseEntity.ok(patientList);
    }
}
