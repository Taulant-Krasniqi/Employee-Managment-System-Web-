package com.AdminDashboard.AdminForm.Repository;


import com.AdminDashboard.AdminForm.Entities.ReviewLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewLeaveRepo extends JpaRepository<ReviewLeave, Integer> {
}
