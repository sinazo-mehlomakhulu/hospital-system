package za.ac.cput.service;


import za.ac.cput.domain.Nurse;

import java.util.Set;

/*
    NurseService.java
    Service Interface for the Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public interface NurseService extends IService<Nurse, String> {
    Set<Nurse> getAll();
}
