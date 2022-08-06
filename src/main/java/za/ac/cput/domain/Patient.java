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
    Patient.java
    Entity: Patient
    Author: Ishmail T Mgwena (215088417)
    Date: 05 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_patient")
public class Patient {

    @Id
    private String patIdNum;
    @NotNull
    private String patFirstName;
    private String patLastName;
    private String patAddress;
    private String patCellNum;

    public Patient(String patIdNum, String patFirstName, String patLastName, String patAddress, String patCellNum){
        this.patIdNum = patIdNum;
        this.patFirstName = patFirstName;
        this.patLastName = patLastName;
        this.patAddress = patAddress;
        this.patCellNum = patCellNum;
    }


}
