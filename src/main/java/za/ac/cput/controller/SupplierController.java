package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.impl.SupplierServiceImpl;

import javax.validation.Valid;
import java.util.List;


/*
    SupplierController.java
    Contoller for Supplier
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 13 October 2022
*/
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private SupplierServiceImpl supplierService;

    @Autowired
    public  SupplierController(SupplierServiceImpl supplierService) {
        this.supplierService = supplierService;
    }
    @GetMapping("/find/{id}")
    public Supplier find(@PathVariable String id) {
        return this.supplierService.findById(id);
    }
    @PostMapping("/save")
    public Supplier save(@RequestBody Supplier supplier) {
        return this.supplierService.save(supplier);
    }
    //Delete method
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return this.supplierService.delete(id);
    }
    @GetMapping("/all")
    public List<Supplier> getAll(){
        return  this.supplierService.getAll();
    }



}
