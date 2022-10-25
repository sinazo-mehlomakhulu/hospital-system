package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.service.CleaningStaffService;
import za.ac.cput.service.impl.CleaningStaffServiceImpl;

import java.util.List;
import java.util.Set;


/*
CleaningStaffController.java
this is Cleaning staff controller
Sinazo Mehlomkhulu (216076498)
Date : 11 October 2022
 */
@RestController
@RequestMapping(path  = "/cleaningStaff/")
@Slf4j
public class CleaningStaffController {
    private CleaningStaffServiceImpl service;

    @Autowired
    public CleaningStaffController(CleaningStaffServiceImpl service) {
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

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/find/{id}")
    public CleaningStaff find(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<CleaningStaff> getAll(){return this.service.getAll();}

}


