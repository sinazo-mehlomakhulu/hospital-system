package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.MedicalAid;
/*
    MedicalAidRepository.java
    Repository for the Medical Aid
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@Repository
public interface MedicalAidRepository extends JpaRepository<MedicalAid, String> {
}
