package net.employee.employeeform.repositories;

import net.employee.employeeform.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {
}
