package za.ac.cput.service.impl;
/*
    PatientServiceImpl.java
    Entity: PatientServiceImpl
    Author: Ishmail T Mgwena (215088417)
    Date: 14 August 2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Patient;
import za.ac.cput.repository.PatientRepository;
import za.ac.cput.service.PatientService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Autowired
    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }
    @Override
    public Patient save(Patient patient) {
        return this.repository.save(patient);
    }
    @Override
    public Patient read(String id) {
        return this.repository.findById(id).orElse(null);
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
    public Set<Patient>getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
