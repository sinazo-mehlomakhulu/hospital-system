package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.factory.CleaningStaffFactory;
import za.ac.cput.service.impl.CleaningStaffServiceImpl;
import java.util.Arrays;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;
//Sinazo Mehlomakhulu(216076498)
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CleaningStaffControllerTest {
    public static String SECURITY_USERNAME = "admin-user";
    public static String SECURITY_PASSWORD = "65ff7492d30";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CleaningStaffController controller;
    @Autowired
    private CleaningStaffServiceImpl service;

    private CleaningStaff cleaningStaff;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.cleaningStaff = CleaningStaffFactory.createCleaningStaff("89756", "Oyena", "Kama" );
        this.baseUrl = "http://localhost:" + this.port + "/cleaningStaff/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<CleaningStaff> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.cleaningStaff, CleaningStaff.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    public void b_read() {
        String url = baseUrl + "find/" + this.cleaningStaff.getEmployeeId();
        System.out.println(url);
        ResponseEntity<CleaningStaff> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, CleaningStaff.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }


    @Test
    public void c_delete() {
        String url = baseUrl + "delete/" + this.cleaningStaff.getEmployeeId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    public void d_findAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<CleaningStaff[]> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, CleaningStaff[].class);
        assertNotNull(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println("Show All:");
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
    }


    }




