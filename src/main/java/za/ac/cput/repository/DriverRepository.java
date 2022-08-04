package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

/*
    DriverRepository.java
    Repository for driver
    Student name: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 4 August 2022
*/

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
}
