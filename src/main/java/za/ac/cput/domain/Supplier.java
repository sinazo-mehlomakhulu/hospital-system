package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Supplier.java
    Entity for supplier
    Student name: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 4 August 2022
*/

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_supplier")
public class Supplier {
    @Id
    private String suppID;

    @NotNull
    private String suppAddress;

    private int suppRegNum;

    public Supplier(String suppID, String suppAddress, int suppRegNum){
        this.suppID = suppID;
        this.suppAddress = suppAddress;
        this.suppRegNum = suppRegNum;
    }
}
