package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
    MedicalAid.java
    Entity for the Medical Aid
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_medical_aid")

public class MedicalAid {

    @Id
    private Integer medicalNum;
    @NotNull
    private String medicalName;
    private String medicAddr;

    public MedicalAid (Integer medicalNum, String medicalName , String medicAddr) {
        this.medicalNum = medicalNum;
        this.medicalName = medicalName;
        this.medicAddr=medicAddr;
    }


}
