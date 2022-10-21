package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.*;
import java.util.Arrays;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

/*
    SupplierControllerTest.java
    Test for the Supplier Controller
    Author: Nonzwakazi Mgxaji
    Date: 16 October 2022
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierControllerTest {
    public static String SECURITY_USERNAME = "admin-user";
    public static String SECURITY_PASSWORD = "65ff7492d30";

    private String baseUrl;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private SupplierController supplierController;


    private Supplier supplier, supplier1;

    @BeforeEach
    void setUp() {
        assertNotNull(supplierController);
        this.supplier = SupplierFactory.createSupplier("4444451", "3 Heather Street Mandalay", "CA123456");
        this.supplier1 = SupplierFactory.createSupplier("5569874","14 Madison Lane Rondebosch","CF58696");
        this.baseUrl = "http://localhost:" + this.port +"/supplier/";
    }

    @Disabled
    @Test
    void a_save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Supplier> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.supplier1, Supplier.class);

        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
        System.out.println(response);
    }

    @Test
    public void b_read() {
        String url = baseUrl + "find/" + this.supplier.getSupplierID();
        System.out.println(url);
        ResponseEntity<Supplier> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Supplier.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }


    @Test
    public void c_delete() {
        String url = baseUrl + "delete/" + this.supplier.getSupplierID();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    public void d_findAll() {
        String url = baseUrl + "all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }
}