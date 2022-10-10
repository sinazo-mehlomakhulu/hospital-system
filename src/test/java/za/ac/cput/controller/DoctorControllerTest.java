package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import za.ac.cput.domain.Doctor;
import za.ac.cput.service.impl.DoctorService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTest {

    private String baseUrl;

    @LocalServerPort
    private int port;

    @Autowired
    private DoctorController doctorController;

    @Autowired
    public DoctorService doctorService;

    private Doctor doctor;

    @BeforeEach
    void setUp()
    {
        assertNotNull(doctorController);
        this.baseUrl = "http://localhost:" + this.port + "/hospital-system/doctor";
    }

    @Test
    void save()
    {
        this.doctor = new Doctor("02JaFo82", "Jane", "Foster", "0236542182");
        this.doctorService.saveDoctor(doctor);
        assertNotNull(doctor);
    }

    @Test
    void read()
    {
        Doctor doctorIdProvided = new Doctor("07sJulie14", "", "", "");
        Doctor checkDocId = this.doctorService.getDoctor(doctorIdProvided.getDocID());
        System.out.println(checkDocId);
        assertSame(checkDocId, doctorIdProvided);
    }

    @Test
    void delete()
    {
        Doctor doctorId = new Doctor("07sJulie14", "", "", "");
        boolean deleted = doctorService.deleteDoctor(doctorId.getDocID());
        assertTrue(deleted);
    }

    @Test
    void findAll()
    {
        List<Doctor> allDoctors = doctorService.listDoctors();
        System.out.println(allDoctors);
        assertNotNull(allDoctors);
    }

}
