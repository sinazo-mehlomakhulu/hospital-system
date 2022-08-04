package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
    Invoice.java
    Entity for the Invoice
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_invoice")
public class Invoice {

        @Id
        private Integer invoiceNum;

        @NotNull
        private Double invoiceAmount;
        private String invoiceType;
        private String invoiceDate;

    private Invoice (Integer invoiceNum, Double invoiceAmount, String invoiceType, String invoiceDate) {
            this.invoiceNum = invoiceNum;
            this.invoiceAmount = invoiceAmount;
            this.invoiceType = invoiceType;
            this.invoiceDate = invoiceDate;
        }
    }
