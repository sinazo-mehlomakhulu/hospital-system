package za.ac.cput.service;

import za.ac.cput.domain.MedicalAid;

import java.util.Set;
/*
    MedicalAidService.java
    Service Interface for MedicalAid
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/
public interface MedicalAidService extends IService<MedicalAid, String> {
    Set<MedicalAid> getAll();
}
