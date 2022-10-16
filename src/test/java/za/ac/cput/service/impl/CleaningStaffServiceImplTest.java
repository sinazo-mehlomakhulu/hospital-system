package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.repository.AppointmentRepository;
import za.ac.cput.repository.CleaningStaffRepository;

import static org.junit.jupiter.api.Assertions.*;
//Sinazo Mehlomakhulu(216076498)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CleaningStaffServiceImplTest {
    @Mock
    private CleaningStaffRepository repository;

    private static CleaningStaff cleaningStaff1,cleaningStaff2;
    CleaningStaffServiceImpl staffService;

    @Order(1)
    @Test
    void save() {
        staffService = new CleaningStaffServiceImpl(repository);
        cleaningStaff1 = new CleaningStaff.Builder().employeeId("8909240759089").employeeFirstName("Andrew").employeeLastName("Mason").build();
        cleaningStaff2 = new CleaningStaff.Builder().employeeId("9307230769080").employeeFirstName("Lunathi").employeeLastName("Kama").build();
        repository.save(cleaningStaff1);
        repository.save(cleaningStaff2);

        assertAll(
                ()-> assertNotNull(cleaningStaff1.getEmployeeId()),
                ()-> assertNotNull(cleaningStaff2.getEmployeeId()),
                ()-> assertNotNull(cleaningStaff1.getEmployeeFirstName()),
                ()-> assertNotNull(cleaningStaff2.getEmployeeFirstName()));
        System.out.println("Appointment has been added");
    }
@Order(2)
    @Test
    void read() {
    repository.getReferenceById(cleaningStaff1.getEmployeeId());
    repository.getReferenceById((cleaningStaff2.getEmployeeId()));
    assertAll(
            ()-> assertNotNull(cleaningStaff1.getEmployeeId()),
            ()-> assertNotNull(cleaningStaff2.getEmployeeId()),
            ()-> assertNotSame(cleaningStaff1.getEmployeeId(),cleaningStaff2.getEmployeeId()),
            ()-> assertNotEquals(cleaningStaff1.getEmployeeId(),cleaningStaff2.getEmployeeId())
    );
    System.out.println(cleaningStaff1.toString());
    System.out.println(cleaningStaff2.toString());
    }
@Order(3)
@Test
void findAll(){
    System.out.println(repository.findAll());
}
@Order(4)
    @Test
    void delete() {
        repository.deleteById(cleaningStaff1.getEmployeeId());
        repository.deleteById(cleaningStaff2.getEmployeeId());

        assertAll(
                ()->assertNotNull(cleaningStaff1.getEmployeeId()),
                ()->assertNotNull(cleaningStaff2.getEmployeeId()),
                ()-> assertNotSame(cleaningStaff1.getEmployeeId(), cleaningStaff2.getEmployeeId()),
                ()-> assertNotEquals(cleaningStaff1.getEmployeeId(),cleaningStaff2.getEmployeeId())
        );

    }

}