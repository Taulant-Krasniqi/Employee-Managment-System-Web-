package net.employee.employeeform.repositories;


import net.employee.employeeform.entities.HolidayCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayCategoryRepo extends JpaRepository<HolidayCategory,Integer> {
}
