package za.ac.cput.service;

import za.ac.cput.domain.CleaningStaff;

import java.util.Set;
/*
  CleaningStaff.java
  Service class for CleaningStaff
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */
public interface CleaningStaffService extends IService<CleaningStaff, String >{
    Set<CleaningStaff> getAll();
}
