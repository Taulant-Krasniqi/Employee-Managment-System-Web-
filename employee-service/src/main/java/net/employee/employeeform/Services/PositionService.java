package net.employee.employeeform.Services;


import net.employee.employeeform.entities.Position;
import net.employee.employeeform.repositories.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public List<Position> findall(){
        return positionRepo.findAll();
    }
}
