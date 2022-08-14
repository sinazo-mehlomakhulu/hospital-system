package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.MedicalAid;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.factory.MedicalAidFactory;

import static org.junit.jupiter.api.Assertions.*;
/*
    MedicalAidServiceImplTest.java
    Service test for MedicalAid
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/
@SpringBootTest
class MedicalAidServiceImplTest {
    private final MedicalAid medAid1 = MedicalAidFactory.createMedicalAid("7422132132","Discovery","67 Burnistone Road, Belleville");
    @Autowired
    private MedicalAidServiceImpl medService;

    @Test
    void save() {
        MedicalAid saved = this.medService.save(this.medAid1);
        assertEquals(this.medAid1, saved);
    }

    @Test
    void read() {
        MedicalAid read = medService.read(medAid1.getMedicalNum());
        assertEquals(read.getMedicalNum(), medAid1.getMedicalNum());
        System.out.println("Read: " + read);
    }

    @Test
    void delete() {
        boolean success = medService.delete(medAid1.getMedicalNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll() {
        System.out.println("Get All");
        System.out.println(medService.getAll());
    }
}