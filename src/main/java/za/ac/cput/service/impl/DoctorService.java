package za.ac.cput.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Doctor;
import za.ac.cput.repository.DoctorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//Sinenhlanhla Zondi

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(String id)
    {
        return doctorRepository.findById(id).orElse(null);
    }

    public boolean deleteDoctor(String id)
    {
        if(doctorRepository.existsById(id))
        {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List listDoctors()
    {
        return doctorRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }



}
