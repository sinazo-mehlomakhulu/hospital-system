package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    HospitalRoom.java
    Entity for the Hospital Rooms
    Author: Fayaad Abrahams (218221630)
    Date: 3 August 2022
*/
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_hospital_room")
public class HospitalRoom {

    @Id
    private String roomID;

    @NotNull
    private int roomFloor;

    public HospitalRoom(String roomID, int roomFloor) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
    }
}
