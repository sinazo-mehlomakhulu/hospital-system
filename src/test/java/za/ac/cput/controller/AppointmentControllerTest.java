package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Appointment;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.service.AppointmentService;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

//Sinazo Mehlomakhulu(216076498)

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {
    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AppointmentController controller;

    @Autowired
    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.appointment = AppointmentFactory.createAppointment("00032", "23 November 2022","30Min","10:00");
        this.service.save(appointment);
        this.baseUrl = "http://localhost:" + this.port + "/hospital system/appointment/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate.postForEntity(url, this.appointment, Appointment.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }
    @Order(2)
    @Test
    public void read() {
        String url = baseUrl + "read/{id}" + this.appointment.getAppointmentId();
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate.getForEntity(url, Appointment.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Order(4)
    @Test
    public void delete() {
        String url = baseUrl + "delete/{id}" + this.appointment.getAppointmentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
@Order(3)
    @Test
    public void findAll() {
        String url = baseUrl + "find-all";
        System.out.println(url);
        ResponseEntity<Appointment[]> response = this.restTemplate.getForEntity(url, Appointment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertEquals(21, response.getBody().length));
    }

}