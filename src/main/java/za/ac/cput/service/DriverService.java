package za.ac.cput.service;

import za.ac.cput.domain.Driver;

import java.util.List;
import java.util.Set;

/*
    DriverService.java
    Services for Driver
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 14 August 2022
*/

public interface DriverService extends IService <Driver, String>{
    List<Driver> getAll();
    Driver findById(String id);

    boolean delete(String id);
}
