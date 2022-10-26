package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Medicine;
import za.ac.cput.factory.MedicineFactory;
import za.ac.cput.service.MedicineService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MedicineControllerTest {

    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MedicineController controller;
    @Autowired
    private MedicineService medicineService;

    private Medicine medicine;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.medicine = MedicineFactory.createMedicine("7638","40","PainKillers");
        this.medicineService.save(medicine);
        this.baseUrl = "http://localhost:" + this.port + "/hospital system/medicine/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Medicine> response = this.restTemplate
                .withBasicAuth("admin-user","65ff7492d30")
                .postForEntity(url, this.medicine, Medicine.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    void b_read() {
        String url = baseUrl + "read/" + this.medicine.getMedicineId();
        ResponseEntity<Medicine> response = this.restTemplate
                .withBasicAuth("admin-user","65ff7492d30")
                .getForEntity(url,Medicine.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    void c_delete() {
        String url = baseUrl + "delete/" + this.medicine.getMedicineId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "find-all";
        System.out.println(url);
        ResponseEntity<Medicine[]> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .getForEntity(url, Medicine[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertEquals(21, response.getBody().length));
    }
}