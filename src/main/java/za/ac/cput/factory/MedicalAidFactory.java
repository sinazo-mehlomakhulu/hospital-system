package za.ac.cput.factory;


import za.ac.cput.domain.MedicalAid;
import za.ac.cput.util.StringHelper;
/*
    MedicalAidFactory.java
    Factory for  MedicalAid
    Author: Shina Kara (219333181)
    Date: 13 August 2022
*/
public class MedicalAidFactory {

    public static MedicalAid createMedicalAid(String medicalNum,String medicalName, String medicAddr){
        StringHelper.checkStringParam("medicalNum", medicalNum);
        StringHelper.checkStringParam("medicalName", medicalName);
        StringHelper.checkStringParam("medicAddr", medicAddr);

        return new MedicalAid.Builder()
                .setMedicalNum(medicalNum)
                .setMedicalName(medicalName)
                .setMedicAddr(medicAddr)
                .build();


    }
}
