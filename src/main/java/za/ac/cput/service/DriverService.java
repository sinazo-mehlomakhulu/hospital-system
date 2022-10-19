package za.ac.cput.service;

import za.ac.cput.domain.Driver;
import java.util.Set;

public interface DriverService {
    Set<Driver> getAll();
    Driver findById(String id);
    Driver findByNum(String driverLicenseNum);


}
