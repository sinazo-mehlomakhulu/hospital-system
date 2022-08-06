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
    Medicine.java
    Entity: Medicine
    Author: Ishmail T Mgwena (215088417)
    Date: 05 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_medicine")
public class Medicine {

    @Id
    private String medicineID;
    @NotNull
    private String medicineAmount;
    private String medicineType;

    public Medicine(String medicineID, String medicineAmount, String medicineType) {
        this.medicineID = medicineID;
        this.medicineAmount = medicineAmount;
        this.medicineType = medicineType;
    }

}
