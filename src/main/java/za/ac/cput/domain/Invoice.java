package za.ac.cput.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
/*
    Invoice.java
    Entity for the Invoice
    Author: Shina Kara (219333181).
    Date: 4 August 2022
*/
@Entity
public class Invoice implements Serializable {
    @Id
    @Column(name = "invoice_num")
    private String invoiceNum;

    @NotNull
    private Double invoiceAmount;

    @NotNull
    private String invoiceType;

    @NotNull
    private String invoiceDate;

    protected Invoice() {
    }

    private Invoice(Builder builder) {
        this.invoiceNum = builder.invoiceNum;
        this.invoiceAmount = builder.invoiceAmount;
        this.invoiceType = builder.invoiceType;
        this.invoiceDate = builder.invoiceDate;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceNum, invoice.invoiceNum) && Objects.equals(invoiceAmount, invoice.invoiceAmount) && Objects.equals(invoiceType, invoice.invoiceType) && Objects.equals(invoiceDate, invoice.invoiceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNum, invoiceAmount, invoiceType, invoiceDate);
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceNum='" + invoiceNum + '\'' + ", invoiceAmount='" + invoiceAmount + '\'' + ", invoiceType='" + invoiceType + '\'' + ", invoiceDate='" + invoiceDate + '\'' + '}';
    }

    public static class Builder {
        private String invoiceNum;
        private Double invoiceAmount;
        private String invoiceType;
        private String invoiceDate;

        public Builder setInvoiceNum(String invoiceNum) {
            this.invoiceNum = invoiceNum;
            return this;
        }

        public Builder setInvoiceAmount(Double invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder setInvoiceType(String invoiceType) {
            this.invoiceType = invoiceType;
            return this;
        }

        public Builder setInvoiceDatee(String invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder copy(Invoice invoice) {
            this.invoiceNum = invoice.invoiceNum;
            this.invoiceAmount = invoice.invoiceAmount;
            this.invoiceType = invoice.invoiceType;
            this.invoiceDate = invoice.invoiceDate;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

}

