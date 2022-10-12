package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.repository.CleaningStaffRepository;
import za.ac.cput.service.CleaningStaffService;


import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Sinazo Mehlomakhulu(216076498)
@Service
@Transactional
public class CleaningStaffServiceImpl{

    private final CleaningStaffRepository repository;

    @Autowired
    public CleaningStaffServiceImpl(CleaningStaffRepository repository) {
        this.repository = repository;
    }


    public CleaningStaff save(CleaningStaff cleaningStaff) {

        return repository.save(cleaningStaff);
    }


    public Optional<CleaningStaff> read(String id) {
        return this.repository.findById(id);
    }


    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Set<CleaningStaff> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

