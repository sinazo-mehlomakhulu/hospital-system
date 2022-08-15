package za.ac.cput.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
/*
   Appointment.java
   Entity for Appointment
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 06 August 2022
 */

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "tbl_Appointment")
public class Appointment {
@Id
private String appointmentId;

@NotNull
    private String appointmentDate;
    private String appointmentDuration;
    private String appointmentTime;

   public Appointment(Builder builder) {
       this.appointmentId = builder.appointmentId;
        this.appointmentDate = builder.appointmentDate;
        this.appointmentDuration = builder.appointmentDuration;
        this.appointmentTime = builder.appointmentTime;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentDate.equals(that.appointmentDate) && appointmentId.equals(that.appointmentId) && appointmentDuration.equals(that.appointmentDuration) && appointmentTime.equals(that.appointmentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, appointmentDate,appointmentDuration,appointmentTime);
    }

    public static class Builder {
        private String appointmentId;
        private String appointmentDate;
        private String appointmentDuration;
        private String appointmentTime;

        public Builder appointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }
        public Builder appointmentDate(String appointmentDate){
            this.appointmentDate = appointmentDate;
            return this;
        }
        public Builder appointmentDuration(String appointmentDuration) {
            this.appointmentDuration = appointmentDuration;
            return this;
        }
        public Builder appointmentTime(String appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }
        public Builder copy(Appointment appointment){
            this.appointmentId = appointment.appointmentId;
            this.appointmentDate = appointment.appointmentDate;
            this.appointmentDuration = appointment.appointmentDuration;
            this.appointmentTime= appointment.appointmentTime;
            return this;
        }
        public Appointment build() {
            return new Appointment(this);

        }


    }


}
