package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
   CleaningStaff.java
   Entity for hospital cleaning staff
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 06 August 2022
 */
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_cleaning_staff")
public class CleaningStaff {

    @Id
    private String employeeId;

    @NotNull
    private String employeeFirstName;
    private String employeeLastName;

    public CleaningStaff(String employeeId, String employeeFirstName, String employeeLastName) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
    }
}
