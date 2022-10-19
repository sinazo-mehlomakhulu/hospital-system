package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.util.StringHelper;

public class SupplierFactory {
    public static Supplier createSupplier(String suppID, String suppAddress, String suppRegNum) {
        StringHelper.checkStringParam("00099900", suppID);
        StringHelper.checkStringParam("suppAddress", suppAddress);
        StringHelper.checkStringParam("suppRegNum", suppRegNum);

        return new Supplier.Builder().suppID(suppID).suppAddress(suppAddress).suppRegNum(suppRegNum).build();
    }
}