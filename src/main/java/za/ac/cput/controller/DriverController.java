package za.ac.cput.controller;

import za.ac.cput.domain.Driver;
import za.ac.cput.service.impl.DriverServiceImpl;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/driver")
public class DriverController {
    private DriverServiceImpl driverService;

    public DriverController(DriverServiceImpl driverService){
        this.driverService = driverService;
    }

    //Read method
    @GetMapping("find/id")
    public Driver find(@PathVariable String id){
        return driverService.findById(id);
    }

    //Save / Create Method
    @PostMapping("save/driver")
    public Driver save(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }

    //Delete method
    @GetMapping("delete/driver")
    public boolean delete(@PathVariable String id){
        return driverService.delete(id);
    }



}