package za.ac.cput.service;

import za.ac.cput.domain.Invoice;
import java.util.Set;
/*
    InvoiceService.java
    Service Interface for Invoice
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/
public interface InvoiceService extends IService<Invoice, String> {
    Set<Invoice> getAll ();
}
