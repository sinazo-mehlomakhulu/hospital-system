package za.ac.cput.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.impl.SupplierServiceImpl;

public class SupplierController {
    private SupplierServiceImpl supplierService;

    public  SupplierController(SupplierServiceImpl supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("find/id")
    public Supplier find(@PathVariable String id) {
        return supplierService.findById(id);
    }

    @PostMapping("save/driver")
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    //Delete method
    @GetMapping("delete/driver")
    public boolean delete(@PathVariable String id){
        return supplierService.delete(id);
    }



}
