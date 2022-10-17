package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Doctor;
import za.ac.cput.service.impl.DoctorService;

import java.util.List;

@RestController
@RequestMapping(path = "hospital-system/doctor")
@Slf4j
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }

    @PostMapping("create")
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("read/{id}")
    public Doctor getDoctor(@PathVariable String id)
    {
        return doctorService.getDoctor(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@RequestParam("id") String id)
    {
        return doctorService.deleteDoctor(id);
    }

    @GetMapping("get-all")
    public List<Doctor> listAll()
    {
        return doctorService.listDoctors();
    }


}
