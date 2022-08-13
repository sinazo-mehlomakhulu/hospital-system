package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CleaningStaff;

@Repository
public interface CleaningStaffRepository extends JpaRepository<CleaningStaff, String> {
}