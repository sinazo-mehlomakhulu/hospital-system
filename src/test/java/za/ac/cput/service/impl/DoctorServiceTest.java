package za.ac.cput.service.impl;

//Sinenhlanhla Zondi

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Doctor;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    void save()
    {
        Doctor doctor = new Doctor("05dJohn16", "John", "Doe", "0123456789");
        Doctor d = doctorService.saveDoctor(doctor);
        Assert.assertSame("05dJohn16", d.getDocID());
    }

    @Test
    void read()
    {
        Doctor doctor = new Doctor("07sJulie14", null, "Smith", "0236571258");
        Doctor d = doctorService.saveDoctor(doctor);
        assertNotNull(d.getFirstName());
    }

    @Test
    void delete()
    {
        Doctor doctor = new Doctor("03cMarcus18", "Marcus", "Cunningham", "");
        boolean deleted = doctorService.deleteDoctor(doctor.getDocID());
        assertSame(false, deleted);
    }

    @Test
    void get()
    {
        assertNull(doctorService.listDoctors());
    }
}
