package net.employee.employeeform.repositories;

import net.employee.employeeform.entities.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepo extends JpaRepository<Departament,Integer> {
}
