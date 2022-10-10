package za.ac.cput.service.impl;
/*
    MedicineServiceImpl.java
    Entity: MedicineServiceImpl
    Author: Ishmail T Mgwena (215088417)
    Date: 14 August 2022
*/

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Medicine;
import za.ac.cput.repository.MedicineRepository;
import za.ac.cput.service.MedicineService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository repository;

    public MedicineServiceImpl(MedicineRepository repository){
        this.repository = repository;
    }
    @Override
    public Medicine save(Medicine medicine) {
        return this.repository.save(medicine);
    }
    @Override
    public Optional<Medicine> read(String id) {
        return this.repository.findById(id);
    }
    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Set<Medicine>  getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
