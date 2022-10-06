package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.domain.Nurse;
import za.ac.cput.factory.NurseFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
        NurseServiceImplTest.java
        Testing Service Implementation for the Nurses
        Author: Fayaad Abrahams (218221630)
        Date: 12 August 2022
    */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class NurseServiceImplTest {
    private static final Nurse nurse1 = NurseFactory.createNurse("01093298", "Janice", "Flopper");
    private static final Nurse nurse2 = NurseFactory.createNurse("23490234", "Antonio", "Degracias");
    private static final Nurse nurse3 = NurseFactory.createNurse("75892745", "Flounder", "Weathers");

    @Autowired
    private NurseServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Nurse created1 = service.save(nurse1);
        assertNotNull(created1);
        System.out.println(created1);

        Nurse created2 = service.save(nurse2);
        assertNotNull(created2);
        System.out.println(created2);

        Nurse created3 = service.save(nurse3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Optional<Nurse> read = service.read(nurse1.getNurseID());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(nurse1, read.get()));
        System.out.println("Read: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(nurse2.getNurseID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}
