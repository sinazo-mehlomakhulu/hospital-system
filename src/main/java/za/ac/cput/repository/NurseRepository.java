package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Nurse;

/*
    NurseRepository.java
    Repository for the Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 3 August 2022
*/
@Repository
public interface NurseRepository extends JpaRepository<Nurse, String> {
}
