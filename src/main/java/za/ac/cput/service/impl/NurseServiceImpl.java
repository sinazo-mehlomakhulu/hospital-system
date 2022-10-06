package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Nurse;
import za.ac.cput.repository.NurseRepository;
import za.ac.cput.service.NurseService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
    NurseServiceImpl.java
    Service Implementation for Nurse
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
@Service
public class NurseServiceImpl implements NurseService {
    private final NurseRepository repository;

    @Autowired
    public NurseServiceImpl(NurseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Nurse save(Nurse nurse) {
        return this.repository.save(nurse);
    }

    @Override
    public Optional<Nurse> read(String id) {
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
    public Set<Nurse> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
