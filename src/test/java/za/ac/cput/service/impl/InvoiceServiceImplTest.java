package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/*
    InvoiceServiceImplTest.java
    Service Test for Invoice
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/

@SpringBootTest
class InvoiceServiceImplTest {

    private final Invoice invoice1 = InvoiceFactory.createInvoice("1919319",223.0,"16/08/22","Cash");
    @Autowired
    private InvoiceServiceImpl invService;

    @Test
    void save() {
        Invoice saved = this.invService.save(this.invoice1);
        assertEquals(this.invoice1, saved);
    }

    @Test
    void read() {
        Optional <Invoice> read = invService.read(invoice1.getInvoiceNum());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(invoice1, read.get()));
        System.out.println("Read: " + read);
    }

    @Test
    void delete() {
        boolean success = invService.delete(invoice1.getInvoiceNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
}

    @Test
    void getAll() {
        System.out.println("Get All");
        System.out.println(invService.getAll());
    }
}