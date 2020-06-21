package com.AdminDashboard.AdminForm.Repository;


import com.AdminDashboard.AdminForm.Entities.RequestLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLeaveRepo extends JpaRepository<RequestLeave, Integer> {
}
