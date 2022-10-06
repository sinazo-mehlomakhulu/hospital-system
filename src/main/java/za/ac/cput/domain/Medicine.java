package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Medicine.java
    Entity: Medicine
    Author: Ishmail T Mgwena (215088417)
    Date: 05 August 2022
*/
@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "tbl_medicine")
public class Medicine {

    @Id
    private String medicineId;
    @NotNull
    private String medicineAmount;
    private String medicineType;

    private Medicine(Builder builder) {
        this.medicineId = builder.medicineId;
        this.medicineAmount = builder.medicineAmount;
        this.medicineType = builder.medicineType;
    }
    public static class Builder {
        private String medicineId,medicineAmount,medicineType;

    public Builder setMedicineId(String medicineId) {
        this.medicineId = medicineId;
        return this;
    }
    public Builder setMedicineAmount(String medicineAmount){
        this.medicineAmount = medicineAmount;
        return this;
    }
    public Builder setMedicineType(String medicineType) {
        this.medicineType = medicineType;
        return this;
    }
    public Builder copy(Medicine medicine){
        this.medicineId = medicine.medicineId;
        this.medicineAmount = medicine.medicineAmount;
        this.medicineType = medicine.medicineType;
        return this;
    }
    public Medicine build() {return new Medicine(this);}
      }
    }


