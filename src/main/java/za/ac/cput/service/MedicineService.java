package za.ac.cput.service;
/*
    MedicineService.java
    Entity: MedicineService
    Author: Ishmail T Mgwena (215088417)
    Date: 14 August 2022
*/
import za.ac.cput.domain.Medicine;

import java.util.Set;

public interface MedicineService extends IService<Medicine, String>{
    Set<Medicine>getAll();
}
