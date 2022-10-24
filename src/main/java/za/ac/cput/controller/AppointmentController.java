package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Doctor;
import za.ac.cput.service.AppointmentService;

import java.util.Set;


/*
 AppointmentController.java
 this is contoller for Appointment
 Sinazo Mehlomakhulu(216076498)
 13/10/2022
 */
@RestController
@RequestMapping(path  = "hospital-system/appointment")
@Slf4j
public class AppointmentController {
    private static AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("save")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);

    }

    @GetMapping("read/{id}")
    public ResponseEntity<Appointment> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Appointment appointment = this.appointmentService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@RequestParam("id") String id) {
        return appointmentService.delete(id);
    }

    @GetMapping("get-all")
    public ResponseEntity<Set<Appointment>> getAll() {
        Set<Appointment> appointment = this.appointmentService.getAll();
        return ResponseEntity.ok(appointment);
    }
}
