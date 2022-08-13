package za.ac.cput.factory;

import za.ac.cput.domain.Nurse;
import za.ac.cput.util.StringHelper;

/*
    NurseFactory.java
    Factory for Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public class NurseFactory {
    public static Nurse createNurse(String nurseID, String nurseFirstName, String nurseLastName) {
        String id = StringHelper.generateUnqiueID();
        StringHelper.checkStringParam("nurseFirstName", nurseFirstName);
        StringHelper.checkStringParam("nurseLastName", nurseLastName);

        if (StringHelper.isEmptyOrNull(id) || StringHelper.isEmptyOrNull(nurseFirstName) || StringHelper.isEmptyOrNull(nurseLastName))
            throw new IllegalArgumentException();
        return new Nurse.Builder().nurseID(id).nurseFirstName(nurseFirstName).nurseLastName(nurseFirstName).build();
    }
}
