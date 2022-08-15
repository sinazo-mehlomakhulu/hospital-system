package za.ac.cput.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/*
   CleaningStaff.java
   Entity for hospital cleaning staff
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 06 August 2022
 */
@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "tbl_CleaningStaff")
public class CleaningStaff {
@Id
    private String employeeID;

@NotNull
    private String employeeFirstName;
    private String employeeLastName;

    public CleaningStaff(Builder builder) {
        this.employeeID = builder.employeeID;
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleaningStaff that = (CleaningStaff)  o;
        return employeeFirstName.equals(that.employeeFirstName) && employeeID.equals(that.employeeID) && employeeLastName.equals(that.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, employeeFirstName,employeeLastName);
    }

    public static class Builder {
        private String employeeID;
        private String employeeFirstName;
        private String employeeLastName;

        public CleaningStaff.Builder employeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public CleaningStaff.Builder employeeFirstName(String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;
            return this;
        }
        public CleaningStaff.Builder employeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;
            return this;
        }

        public CleaningStaff.Builder copy( CleaningStaff cleaningStaff) {
            this.employeeID = cleaningStaff.employeeID;
            this.employeeFirstName = cleaningStaff.employeeFirstName;
            this.employeeLastName = cleaningStaff.employeeLastName;
            return this;
        }

        public CleaningStaff build() {
            return new CleaningStaff(this);
        }
    }
}






