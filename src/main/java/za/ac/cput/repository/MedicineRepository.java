package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Medicine;

/*
    Medicine.java
    Entity: MedicineRepository
    Author: Ishmail T Mgwena (215088417)
    Date: 05 August 2022
*/
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String> {
}
