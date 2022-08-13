package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.repository.HospitalRoomRepository;
import za.ac.cput.service.HospitalRoomService;

import java.util.Set;
import java.util.stream.Collectors;

/*
    HospitalRoomServiceImpl.java
    Service Implementation for the Hospital Rooms
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
@Service
public class HospitalRoomServiceImpl implements HospitalRoomService {

    private final HospitalRoomRepository repository;

    @Autowired
    public HospitalRoomServiceImpl(HospitalRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public HospitalRoom save(HospitalRoom hospitalRoom) {
        return this.repository.save(hospitalRoom);
    }

    @Override
    public HospitalRoom read(String id) {
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
    public Set<HospitalRoom> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
