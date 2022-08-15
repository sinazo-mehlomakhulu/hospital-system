package za.ac.cput.service;

import za.ac.cput.domain.Appointment;

import java.util.Set;
/*
   AppointmentService.java
   Service calss for Appointment
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */
public interface AppointmentService extends IService<Appointment,String >{
 Set<Appointment> getAll();
}
