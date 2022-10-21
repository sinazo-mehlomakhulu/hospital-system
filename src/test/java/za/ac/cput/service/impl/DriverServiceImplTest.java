package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/*
    DriverServiceImplTest.java
    Service Implementation Test for Driver
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 10 October 2022
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class DriverServiceImplTest {
    private static final Driver driver1 = DriverFactory.createDriver("2415", "Nzwakie", "Mgxaji", "123456");
    private static final Driver driver2 = DriverFactory.createDriver("4578", "Given", "Carter", "457852");
    private static final Driver driver3 = DriverFactory.createDriver("9634", "Mariam", "Peters", "8859661");

    @Autowired
    private DriverServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Driver created1 = service.save(driver1);
        assertNotNull(created1);
        System.out.println(created1);

        Driver created2 = service.save(driver2);
        assertNotNull(created2);
        System.out.println(created2);

        Driver created3 = service.save(driver3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Optional<Driver> read = service.read(driver1.getDriverID());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(driver1, read.get()));
        System.out.println("Read: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(driver2.getDriverID());
        assertTrue(success);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getALl() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}
