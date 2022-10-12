package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Doctor;
import za.ac.cput.service.impl.DoctorService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DoctorController doctorController;

    @Autowired
    public DoctorService doctorService;

    private Doctor doctor;

    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "pass123";

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
        //List<Doctor> allDoctors = doctorService.listDoctors();

        String url = "http://localhost:" + this.port + "/hospital-system/doctor";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        //System.out.println(allDoctors);
        //assertNotNull(allDoctors);
    }

}
