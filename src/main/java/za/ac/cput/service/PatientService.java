package za.ac.cput.service;
/*
    PatientService.java
    Entity: PatientService
    Author: Ishmail T Mgwena (215088417)
    Date: 14 August 2022
*/
import za.ac.cput.domain.Patient;

import java.util.Set;

public interface PatientService extends IService<Patient, String>{
    Set<Patient> getAll();
}
