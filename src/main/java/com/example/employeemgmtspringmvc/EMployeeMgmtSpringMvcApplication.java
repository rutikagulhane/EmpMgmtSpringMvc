package com.example.employeemgmtspringmvc;

import com.example.employeemgmtspringmvc.Model.entities.Employee;
import com.example.employeemgmtspringmvc.repo.EmployeeRepo;
import com.example.employeemgmtspringmvc.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EMployeeMgmtSpringMvcApplication {

    private EmployeeRepo repo;

    public EMployeeMgmtSpringMvcApplication(EmployeeRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(EMployeeMgmtSpringMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner runner()
    {
        return args -> {
            repo.save(Employee.builder().firstName("Rutika").lastName("Gulhane").email("rutika@gmail").build());
            repo.save(Employee.builder().firstName("Vaibhav").lastName("Dave").email("Dave@gmail").build());
        };
    }
}
