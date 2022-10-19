package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.Set;


public interface SupplierService extends IService<Supplier, String>{
    Supplier findById(String id);

    Supplier findByNum(String suppRegNum);
    Set<Supplier> getAll();
}
