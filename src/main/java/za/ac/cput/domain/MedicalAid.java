package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
/*
    MedicalAid.java
    Entity for the Medical Aid
    Author: Shina Kara (219333181).
    Date: 4 August 2022
*/
@Entity
public class MedicalAid implements Serializable {
    @NotNull
    @Id
    @Column(name = "medical_num")
    private String medicalNum;
    @NotNull
    private String medicalName;
    @NotNull
    private String medicAddr;

    public MedicalAid() {
    }

    private MedicalAid(Builder builder) {
        this.medicalNum = builder.medicalNum;
        this.medicalName = builder.medicalName;
        this.medicAddr = builder.medicAddr;
    }

    @Override
    public String toString() {
        return "MedicalAid{" +
                "medicalNum='" + medicalNum + '\'' +
                ", medicalName='" + medicalName + '\'' +
                ", medicAddr='" + medicAddr + '\'' +
                '}';
    }

    public String getMedicalNum() {
        return medicalNum;
    }

    public void setMedicalNum(String medicalNum) {
        this.medicalNum = medicalNum;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public String getMedicAddr() {
        return medicAddr;
    }

    public void setMedicAddr(String medicAddr) {
        this.medicAddr = medicAddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalAid that = (MedicalAid) o;
        return Objects.equals(medicalNum, that.medicalNum) && Objects.equals(medicalName, that.medicalName) && Objects.equals(medicAddr, that.medicAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalNum, medicalName, medicAddr);
    }

    public static class Builder {
        private String medicalNum;
        private String medicalName;
        private String medicAddr;


        public Builder setMedicalNum(String medicalNum) {
            this.medicalNum = medicalNum;
            return this;
        }

        public Builder setMedicalName(String medicalName) {
            this.medicalName = medicalName;
            return this;
        }

        public Builder setMedicAddr(String medicAddr) {
            this.medicAddr = medicAddr;
            return this;
        }


        public Builder copy(MedicalAid medicalAid) {
            this.medicalNum = medicalAid.medicalNum;
            this.medicalName = medicalAid.medicalName;
            this.medicAddr = medicalAid.medicAddr;

            return this;
        }

        public MedicalAid build() {
            return new MedicalAid(this);
        }
    }
}
