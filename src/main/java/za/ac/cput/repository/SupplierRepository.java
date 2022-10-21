package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Supplier;

/*
    SupplierRepository.java
    Repository for supplier
    Student name: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 4 August 2022
*/

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
