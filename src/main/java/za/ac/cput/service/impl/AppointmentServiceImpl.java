package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotaion.Autowired;
import za.ac.cput.domain.Appointment;
import za.ac.cput.repository.AppointmentRepository;
import za.ac.cput.service.AppointmentService;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
/*
   AppointmentServiceImpl.java
  Service implementation for Appointment
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private  AppointmentRepository repository;
@Autowired
public AppointmentServiceImpl(AppointmentRepository repository){
    this.repository = repository;
}
    @Override
    public Appointment save(Appointment appointment){
        return this.repository.save(appointment);
    }
    @Override
    public Appointment read(String Id){
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
    public Set<Appointment>getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
   }
}