package com.AdminDashboard.AdminForm.Services;


import com.AdminDashboard.AdminForm.Entities.HolidayCategory;
import com.AdminDashboard.AdminForm.Repository.HolidayCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayCategoryService {



    @Autowired
    private HolidayCategoryRepo holidayCategoryRepo;




    public List<HolidayCategory> getAllCategories(){

        return holidayCategoryRepo.findAll();

    }

    public HolidayCategory getById(int id){

        Optional<HolidayCategory> temp = holidayCategoryRepo.findById(id);

        return temp.get();

    }



    public void addHolidayCat(HolidayCategory holidayCategory){

        holidayCategoryRepo.save(holidayCategory);

    }

    public void editHolidayCat(HolidayCategory holidayCategory){

        holidayCategoryRepo.saveAndFlush(holidayCategory);

    }

    public void deleteHolidayCatByInt(int id){

        holidayCategoryRepo.deleteById(id);

    }



}
