package za.ac.cput.domain;

//import com.sun.istack.NotNull;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/*
    HospitalRoom.java
    Entity for the Hospital Rooms
    Author: Fayaad Abrahams (218221630)
    Date: 3 August 2022
*/
@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "tbl_hospital_room")
public class HospitalRoom {

    @Id
    private String roomID;

    @NotNull
    private int roomFloor;

    public HospitalRoom(Builder builder) {
        this.roomID = builder.roomID;
        this.roomFloor = builder.roomFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalRoom that = (HospitalRoom) o;
        return roomFloor == that.roomFloor && roomID.equals(that.roomID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, roomFloor);
    }

    public static class Builder {
        private String roomID;
        private int roomFloor;

        public Builder roomID(String roomID) {
            this.roomID = roomID;
            return this;
        }

        public Builder roomFloor(int roomFloor) {
            this.roomFloor = roomFloor;
            return this;
        }

        public Builder copy(HospitalRoom hospitalRoom) {
            this.roomID = hospitalRoom.roomID;
            this.roomFloor = hospitalRoom.roomFloor;
            return this;
        }

        public HospitalRoom build() {
            return new HospitalRoom(this);
        }
    }
}
