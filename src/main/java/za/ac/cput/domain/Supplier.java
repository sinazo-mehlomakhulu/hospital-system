package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/*
    Supplier.java
    Supplier Entity
    Author: Nonzwakazi Mgxaji 213181584
    Date: 4 August 2022
*/
@Entity
@Table(name = "tbl_supplier")
public class Supplier implements Serializable {

    @Id
    private String suppID;
    @NotNull
    private String suppAddress;
    private String suppRegNum;

    public Supplier(Builder builder) {
        this.suppID = builder.suppID;
        this.suppAddress = builder.suppAddress;
        this.suppRegNum = builder.suppRegNum;
    }

    public Supplier() {
    }

    public String getSupplierID() {
        return suppID;
    }

    public String getSupplierAddress() {
        return suppAddress;
    }

    public String getSupplierRegNum() {
        return suppRegNum;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "suppID='" + suppID + '\'' +
                ", suppAddress='" + suppAddress + '\'' +
                ", suppRegNum='" + suppRegNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return suppID.equals(supplier.suppID) && suppAddress.equals(supplier.suppAddress) && suppRegNum.equals(supplier.suppRegNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suppID, suppAddress, suppRegNum);
    }

    public static class Builder {
        private String suppID, suppAddress, suppRegNum;

        public Builder suppID(String suppID) {
            this.suppID = suppID;
            return this;
        }

        public Builder suppAddress(String suppAddress) {
            this.suppAddress = suppAddress;
            return this;
        }

        public Builder suppRegNum(String suppRegNum) {
            this.suppRegNum = suppRegNum;
            return this;
        }

        public Builder copy(Supplier supplier) {
            this.suppID = supplier.suppID;
            this.suppAddress = supplier.suppAddress;
            this.suppRegNum = supplier.suppRegNum;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }
}