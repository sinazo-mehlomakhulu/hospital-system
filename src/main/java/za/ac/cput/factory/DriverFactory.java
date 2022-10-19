package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.util.StringHelper;

public class DriverFactory {

    public static Driver createDriver(String driverID, String driverFirstName, String driverLastName, String driverLicenseNum) {
        StringHelper.checkStringParam("00099900", driverID);
        StringHelper.checkStringParam("driverFirstName", driverFirstName);
        StringHelper.checkStringParam("driverLastName", driverLastName);
        StringHelper.checkStringParam("CA123456", driverLicenseNum);

        return new Driver.Builder().driverID(driverID).driverFirstName(driverFirstName).driverLastName(driverLastName).driverLicenseNum(driverLicenseNum).build();
    }
}
