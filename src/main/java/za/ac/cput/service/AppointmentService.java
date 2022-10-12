package za.ac.cput.service;

import za.ac.cput.domain.HospitalRoom;

import java.util.Set;

/*
    HospitalRoomService.java
    Service Interface for the Hospital Rooms
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public interface AppointmentService extends IService<HospitalRoom, String> {
    Set<HospitalRoom> getAll();
}
