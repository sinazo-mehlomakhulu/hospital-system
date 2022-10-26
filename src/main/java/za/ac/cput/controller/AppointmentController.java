package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Appointment;
import za.ac.cput.service.impl.AppointmentServiceImpl;
import java.util.List;



/*
 AppointmentController.java
 this is contoller for Appointment
 Sinazo Mehlomakhulu(216076498)
 13/10/2022
 */
@RestController
@RequestMapping(path  = "/appointment")
@Slf4j
public class AppointmentController {
    private AppointmentServiceImpl service;
    @Autowired
    public AppointmentController(AppointmentServiceImpl service){
        this.service = service;
    }


    @GetMapping("/find/{id}")
    public Appointment find(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping("/save")
    public Appointment save(@RequestBody Appointment appointment){
        return service.save(appointment);
    }

    //Delete method
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public List<Appointment> getAll(){return this.service.getAll();}




}
