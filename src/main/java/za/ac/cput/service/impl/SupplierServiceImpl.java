package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;
import za.ac.cput.service.SupplierService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl (SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public Supplier save(Supplier supplier)
    {
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplier(String id)
    {
        return supplierRepository.findById(id).orElse(null);
    }


    @Override
    public Set<Supplier> getAll() {
        return null;
    }

    @Override
    public Supplier findById(String id) {
        return supplierRepository.findById(id).orElse(new Supplier());
    }

    @Override
    public Supplier findByNum(String suppRegNum) {
        return supplierRepository.findById(suppRegNum).orElse(new Supplier()) ;
    }

    @Override
    public Optional<Supplier> read(String s) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        if (this.supplierRepository.existsById(id)) {
            this.supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List listSupplier() {
        return supplierRepository.findAll().stream().collect(Collectors.toList());
    }
}
