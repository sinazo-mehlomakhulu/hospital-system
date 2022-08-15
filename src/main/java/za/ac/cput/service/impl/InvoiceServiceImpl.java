package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.InvoiceService;


import java.util.Set;
import java.util.stream.Collectors;
/*
    InvoiceServiceImpl.java
    Service impl for Invoice
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return this.repository.save(invoice);
    }

    @Override
    public Invoice read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Invoice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}
