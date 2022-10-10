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
    Driver.java
    Entity for driver
    Student name: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 4 August 2022
*/

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_driver")
public class Driver {
    @Id
    private String driverID;

    @NotNull
    private String driverFirstName;

    private String driverLastName;

    private int driverLicenseNum;

    public Driver(String driverID, String driverFirstName, String driverLastName, int driverLicenseNum){
        this.driverID = driverID;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverLicenseNum = driverLicenseNum;
    }
}
