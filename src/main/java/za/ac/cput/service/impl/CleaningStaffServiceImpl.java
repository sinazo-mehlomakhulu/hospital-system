package za.ac.cput.service.impl;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.CleaningStaffRepository;
import za.ac.cput.service.CleaningStaffService;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Sinazo Mehlomakhulu(216076498)
@Service
@Transactional
public class CleaningStaffServiceImpl implements CleaningStaffService{

    private final CleaningStaffRepository repository;

    @Autowired
    public CleaningStaffServiceImpl(CleaningStaffRepository repository) {
        this.repository = repository;
    }

@Override
    public CleaningStaff save(CleaningStaff cleaningStaff) {

        return repository.save(cleaningStaff);
    }

@Override
    public Optional<CleaningStaff> read(String id) {
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
    public List<CleaningStaff> getAll() {
        return this.repository.findAll();
    }
    @Override
    public CleaningStaff findById(String id) {
        return repository.findById(id).orElse(new CleaningStaff());
    }

    public List listCleaningStaff()
    {
        return repository.findAll().stream().collect(Collectors.toList());
    }

}




