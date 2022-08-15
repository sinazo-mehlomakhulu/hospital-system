package za.ac.cput.factory;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.util.StringHelper;
/*
  CleaningStaffFactory.java
  Factory class for CleaningStaff
   Author: Sinazo Mehlomakhulu(216076498)
   Date: 13 August 2022
 */


public class CleaningStaffFactory  {
    public static CleaningStaff createCleaningStaff(String employeeId,String employeeFirstName, String employeeLastName ) {
        String Id = StringHelper.generateUnqiueID();
        StringHelper.checkStringParam("EmployeeFirstName", employeeFirstName);
        StringHelper.checkStringParam("EmployeeLastName", employeeLastName);

        if (StringHelper.isEmptyOrNull(Id) || StringHelper.isEmptyOrNull(employeeFirstName) || StringHelper.isEmptyOrNull(employeeLastName))
            throw new IllegalArgumentException();
            return new CleaningStaff.Builder().employeeID(employeeId).employeeFirstName(employeeFirstName).employeeLastName(employeeLastName).build();
        }
}
