package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.domain.Secretary;
import za.ac.cput.factory.CleaningStaffFactory;
import za.ac.cput.service.CleaningStaffService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CleaningStaffControllerTest {
    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CleaningStaffController controller;

    @Autowired
    private CleaningStaffService service;

    private CleaningStaff cleaningStaff;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.cleaningStaff = CleaningStaffFactory.createCleaningStaff("765899735847", "Akhona", "Jacobs");
        this.service.save(cleaningStaff);
        this.baseUrl = "http://localhost:" + this.port + "/hospital system/cleaningstaff/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<CleaningStaff> response = this.restTemplate.postForEntity(url, this.cleaningStaff, CleaningStaff.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }
    @Order(2)
    @Test
    public void read() {
        String url = baseUrl + "read/" + this.cleaningStaff.getEmployeeId();
        System.out.println(url);
        ResponseEntity<CleaningStaff> response = this.restTemplate.getForEntity(url, CleaningStaff.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Order(4)
    @Test
    public void delete() {
        String url = baseUrl + "delete/" + this.cleaningStaff.getEmployeeId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
    @Order(3)
    @Test
    public void findAll() {
        String url = baseUrl + "find-all";
        System.out.println(url);
        ResponseEntity<CleaningStaff[]> response = this.restTemplate.getForEntity(url, CleaningStaff[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertEquals(21, response.getBody().length));
    }
    }




