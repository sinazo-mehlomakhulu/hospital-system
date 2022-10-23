package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.service.InvoiceService;

import java.util.Optional;
import java.util.Set;
/*
    InvoiceController.java
    Controller for the Invoice
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@RestController
@RequestMapping("hospital-system/invoice/")
@Slf4j
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("save")
    public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
        log.info("Save request: {}", invoice);
        Invoice validatedInvoice;
        try {
            validatedInvoice = InvoiceFactory.createInvoice(invoice.getInvoiceNum(), invoice.getInvoiceAmount(),invoice.getInvoiceType(), invoice.getInvoiceDate());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Invoice save = invoiceService.save(validatedInvoice);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Optional<Invoice>> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Optional<Invoice> invoice = this.invoiceService.read(id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Invoice>> findAll() {
        Set<Invoice> invoices = this.invoiceService.getAll();
        return ResponseEntity.ok(invoices);
    }

}
