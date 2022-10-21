package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.service.CleaningStaffService;

import java.util.Set;


/*
CleaningStaffController.java
this is Cleaning staff controller
Sinazo Mehlomkhulu (216076498)
Date : 11 October 2022
 */
@RestController
@RequestMapping(path  = "hospital-system/cleaningStaff")
@Slf4j
public class CleaningStaffController {
    private final CleaningStaffService service;

    @Autowired
    public CleaningStaffController(CleaningStaffService service) {
        this.service = service;
    }

    @PostMapping("save")
    public CleaningStaff createCleaningStaff(@RequestBody CleaningStaff cleaningStaff) {
        return service.save(cleaningStaff);

    }

    @GetMapping("read/{id}")
    public ResponseEntity<CleaningStaff> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        CleaningStaff cleaningStaff = this.service.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(cleaningStaff);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@RequestParam("id") String id) {
        return service.delete(id);
    }

    @GetMapping("find-all")
    public ResponseEntity<Set<CleaningStaff>> getAll() {
        Set<CleaningStaff> cleaningStaffList = this.service.getAll();
        return ResponseEntity.ok(cleaningStaffList);
    }
}


