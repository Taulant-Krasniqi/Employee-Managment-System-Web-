package net.employee.employeeform.repositories;


import net.employee.employeeform.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {
}
