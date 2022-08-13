package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Sinenhlanhla Zondi

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_secretary")
public class Secretary {

    @Id
    private String secID;

    @NotNull
    private String secFirstName;
    private String secLastName;

    public Secretary(String secID, String secFirstName, String secLastName) {
        this.secID = secID;
        this.secFirstName = secFirstName;
        this.secLastName = secLastName;
    }
}
