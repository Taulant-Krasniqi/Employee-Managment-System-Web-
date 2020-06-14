package net.employee.employeeform.Services;

import net.employee.employeeform.entities.Departament;
import net.employee.employeeform.repositories.DepartamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentService {


    @Autowired
    private DepartamentRepo departamentRepo;



    public List<Departament> getAll(){
        return departamentRepo.findAll();
    }
}
