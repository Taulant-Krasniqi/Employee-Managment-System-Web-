package com.AdminDashboard.AdminForm.Repository;


import com.AdminDashboard.AdminForm.Entities.HolidayCategory;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayCategoryRepo extends JpaRepository<HolidayCategory,Integer> {

}
