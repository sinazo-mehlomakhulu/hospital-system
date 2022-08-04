package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Nurse.java
    Entity for the Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 3 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_nurse")
public class Nurse {

    @Id
    private String nurseID;
    @NotNull
    private String nurseFirstName;
    private String nurseLastName;

    public Nurse(String nurseID, String nurseFirstName, String nurseLastName) {
        this.nurseID = nurseID;
        this.nurseFirstName = nurseFirstName;
        this.nurseLastName = nurseLastName;
    }
}
