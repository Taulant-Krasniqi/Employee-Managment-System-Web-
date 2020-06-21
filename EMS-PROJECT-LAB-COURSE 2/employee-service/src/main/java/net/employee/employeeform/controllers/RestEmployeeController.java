package net.employee.employeeform.controllers;


import net.employee.employeeform.Services.DepartamentService;
import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.Services.HolidayCategoryService;
import net.employee.employeeform.Services.PositionService;
import net.employee.employeeform.entities.Departament;
import net.employee.employeeform.entities.Employee;
import net.employee.employeeform.entities.HolidayCategory;
import net.employee.employeeform.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestEmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private HolidayCategoryService holidayCategoryService;


    //    This is for later use, to make Restful API Calls to this method
    @GetMapping("/Employee/Getall")
    public List<Employee> getTotalEmp() {

        return employeeService.getall();

    }

    @GetMapping("/Departament/Getall")

    public List<Departament> getTotalDep() {

        return departamentService.getAll();


    }

    @GetMapping("/Getemployee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        return employeeService.getById(employeeId);

    }


    @DeleteMapping("/Employee/Delete/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.getById(employeeId);

        employeeService.DeleteEmployeeById(employeeId);


        return "Deleted User " + employee.getFirstName();

    }

    @DeleteMapping("/Holiday-Category-Delete/{categoryId}")
    public String deleteHolidayCategory(@PathVariable int categoryId){

        holidayCategoryService.deleteHolidayCatByInt(categoryId);

        return "Deleted HolidayCategory";

    }

    @PostMapping("/Employee/Add")

    public String AddEmployee(@RequestBody Employee employee) {


        employeeService.SaveEmployee(employee);


        return "Employee added";

    }

    @PostMapping("/Holiday-Category-Add")
    public String addHolidayCat(@RequestBody HolidayCategory holidayCategory){

        holidayCategoryService.addHolidayCat(holidayCategory);


        return "HolidayCat Added";

    }

    @PutMapping("/Holiday-Category/Update/{categoryId}")
    public String editHolidayCat(@RequestBody HolidayCategory holidayCategory, @PathVariable int categoryId){
        HolidayCategory tempHoliday = holidayCategoryService.getById(categoryId);

        tempHoliday.setCategoryName(holidayCategory.getCategoryName());
        tempHoliday.setCategoryDays(holidayCategory.getCategoryDays());

        holidayCategoryService.editHolidayCat(tempHoliday);

        return "Holiday Category Edited";
    }




    @PutMapping("/Employee/Update/{employeeId}")
    public String editEmployee(@RequestBody Employee newEmployee, @PathVariable int employeeId) {

        Employee temp = employeeService.getById(employeeId);


        temp.setFirstName(newEmployee.getFirstName());
        temp.setLastName(newEmployee.getLastName());
        temp.setEmail(newEmployee.getEmail());
        temp.setBirthday(newEmployee.getBirthday());
        temp.setStreetName(newEmployee.getStreetName());
        temp.setTown(newEmployee.getTown());
        temp.setZipCode(newEmployee.getZipCode());
        temp.setBankName(newEmployee.getBankName());
        temp.setBankDetails(newEmployee.getBankDetails());
        temp.setGender(newEmployee.getGender());
        temp.setPhone(newEmployee.getPhone());
        temp.setPositionByPositionId(newEmployee.getPositionByPositionId());
        temp.setDepartamentByDepartamentId(newEmployee.getDepartamentByDepartamentId());

        employeeService.SaveEmployee(temp);

        return "Employee Updated";
    }


    @GetMapping("/Position/GetAll")
    public List<Position> getAllPos() {
        return positionService.findall();
    }



}


