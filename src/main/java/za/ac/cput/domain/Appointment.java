package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import jaxax.persistence.Id;
import javax.persistence.Table;
/*
   Appointment.java
   Entity for Appointment
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 06 August 2022
 */

@Entity
@Getter
@ToString
@Builder
@NoArgConstructor
@Table(name = "tbl_appointment")

public class Appointment {
    @Id
    private String AppointmentId;

    @NotNull

    private String appointmentDate;
    private String appointmentDuration;
    private String appointmentTime;

    public Appointment(String appointmentId, String appointmentDate,String appointmentDuration, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDuration = appointmentDuration;
        this.appointmentTime = appointmentTime;
    }
}
