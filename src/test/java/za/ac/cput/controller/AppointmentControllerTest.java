package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.factory.CleaningStaffFactory;
import za.ac.cput.service.AppointmentService;
import za.ac.cput.service.impl.AppointmentServiceImpl;
import za.ac.cput.service.impl.CleaningStaffServiceImpl;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

//Sinazo Mehlomakhulu(216076498)

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {
    public static String SECURITY_USERNAME = "admin-user";
    public static String SECURITY_PASSWORD = "65ff7492d30";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AppointmentController controller;
    @Autowired
    private AppointmentServiceImpl service;

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.appointment = AppointmentFactory.createAppointment("0056", "23July 2022", "30min","10:00" );
        this.baseUrl = "http://localhost:" + this.port + "/appointment/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.appointment, Appointment.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    public void b_read() {
        String url = baseUrl + "find/" + this.appointment.getAppointmentId();
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Appointment.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }


    @Test
    public void c_delete() {
        String url = baseUrl + "delete/" + this.appointment.getAppointmentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    public void d_findAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Appointment[]> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Appointment[].class);
        assertNotNull(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println("Show All:");
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
    }


}




