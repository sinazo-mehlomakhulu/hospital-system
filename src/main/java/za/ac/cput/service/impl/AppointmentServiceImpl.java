package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Appointment;
import za.ac.cput.repository.AppointmentRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Sinazo Mehlomakhulu(21607698)
public class AppointmentServiceImpl {
    private final AppointmentRepository repository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }


    public Appointment save(Appointment appointment) {

        return repository.save(appointment);
    }


    public Optional<Appointment> read(String id) {
        return this.repository.findById(id);
    }


    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Set<Appointment> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}



