package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.factory.HospitalRoomFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
        HospitalRoomServiceImplTest.java
        Testing Service Implementation for the Hospital Rooms
        Author: Fayaad Abrahams (218221630)
        Date: 12 August 2022
    */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class HospitalRoomServiceImplTest {
    private static final HospitalRoom hospitalRoom1 = HospitalRoomFactory.createHospitalRoom("1919319", 2);
    private static final HospitalRoom hospitalRoom2 = HospitalRoomFactory.createHospitalRoom("", 12);
    private static final HospitalRoom hospitalRoom3 = HospitalRoomFactory.createHospitalRoom("", 3);
    @Autowired
    private HospitalRoomServiceImpl service;

    @Test
    public void a_save() {
        System.out.println("Created: ");
        HospitalRoom created1 = service.save(hospitalRoom1);
        assertNotNull(created1);
        System.out.println(created1);

        HospitalRoom created2 = service.save(hospitalRoom2);
        assertNotNull(created2);
        System.out.println(created2);

        HospitalRoom created3 = service.save(hospitalRoom3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    public void b_read() {
        Optional<HospitalRoom> read = service.read(hospitalRoom1.getRoomID());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(hospitalRoom1, read.get()));
        System.out.println("Read: " + read);
    }

    @Test
    public void f_delete() {
        boolean success = service.delete(hospitalRoom3.getRoomID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    public void d_getALl() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }

}
