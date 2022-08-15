package za.ac.cput.factory;
import za.ac.cput.domain.Appointment;
import za.ac.cput.util.StringHelper;
/*
   AppointmentFactory.java
   Factory class for Appointment
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */


public class AppointmentFactory {
public static Appointment createAppointment(String appointmentId,String appointmentDate,String appointmentDuration, String appointmentTime ){
    appointmentId = StringHelper.generateUnqiueID();
    StringHelper.checkStringParam("appointmentDate",appointmentDate);
    StringHelper.checkStringParam("appointmentTime",appointmentTime);
    StringHelper.checkStringParam("appointmentDuration",appointmentDuration);

    return new Appointment.Builder().appointmentDate(appointmentDate).appointmentDuration(appointmentDuration).appointmentTime(appointmentTime).build();
}

}
