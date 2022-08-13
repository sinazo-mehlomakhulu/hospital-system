package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/*
    Nurse.java
    Entity for the Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 3 August 2022
*/
@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "tbl_nurse")
public class Nurse {

    @Id
    private String nurseID;
    @NotNull
    private String nurseFirstName;
    private String nurseLastName;

    public Nurse(Builder builder) {
        this.nurseID = builder.nurseID;
        this.nurseFirstName = builder.nurseFirstName;
        this.nurseLastName = builder.nurseLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return nurseID.equals(nurse.nurseID) && nurseFirstName.equals(nurse.nurseFirstName) && nurseLastName.equals(nurse.nurseLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nurseID, nurseFirstName, nurseLastName);
    }

    public static class Builder {
        private String nurseID, nurseFirstName, nurseLastName;

        public Builder nurseID(String nurseID) {
            this.nurseID = nurseID;
            return this;
        }

        public Builder nurseFirstName(String nurseFirstName) {
            this.nurseFirstName = nurseFirstName;
            return this;
        }

        public Builder nurseLastName(String nurseLastName) {
            this.nurseLastName = nurseLastName;
            return this;
        }

        public Builder copy(Nurse nurse) {
            this.nurseID = nurse.nurseID;
            this.nurseFirstName = nurse.nurseFirstName;
            this.nurseLastName = nurse.nurseLastName;
            return this;
        }

        public Nurse build() {
            return new Nurse(this);
        }
    }
}
