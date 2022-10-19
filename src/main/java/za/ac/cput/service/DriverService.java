package za.ac.cput.service;

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface DriverService extends IService <Driver, String>{
    Set<Driver> getAll();
    Driver findById(String id);
    //Driver findByNum(String driverLicenseNum);


    boolean delete(String id);
}
