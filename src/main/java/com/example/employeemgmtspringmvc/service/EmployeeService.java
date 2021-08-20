package com.example.employeemgmtspringmvc.service;

import com.example.employeemgmtspringmvc.Model.entities.Employee;
import com.example.employeemgmtspringmvc.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepo repo;

    public List<Employee> getAllEmployee()
    {
        return repo.findAll();
    }
    public void saveEmployee(Employee employee)
    {
         repo.save(employee);
    }
    public Employee getEmployeebyid(Long id)
    {
        Optional<Employee> Opt = repo.findById(id);
        Employee employee=null;
     if(Opt.isPresent())
     {
        employee=Opt.get();
     }
     else
     {
         throw new RuntimeException("Employee not found for id"+id);

     }
     return employee;
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
