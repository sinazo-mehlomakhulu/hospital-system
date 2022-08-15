package za.ac.cput.service.impl;


import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.repository.CleaningStaffRepository;
import za.ac.cput.service.CleaningStaffService;

import java.util.Set;
import java.util.stream.Collectors;
/*
  CleaningStaffServiceImpl.java
  Service implementation class for cleaning staff
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */
@Service
public class CleaningStaffServiceImpl implements CleaningStaffService {
    private CleaningStaffRepository repository;

    @Override
    public CleaningStaff save(CleaningStaff cleaningStaff){
        return this.repository.save(cleaningStaff);
    }
    @Override
    public CleaningStaff read(String Id){
        return this.repository.findById(Id).orElse(null);
    }
    @Override
    public boolean delete(String Id) {
        if(this.repository.existById(Id)){
            this.repository.deleteById(Id);
            return true;
        }
        return false;
    }
    @Override
    public Set<CleaningStaff> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

