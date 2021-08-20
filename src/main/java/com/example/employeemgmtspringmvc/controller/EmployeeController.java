package com.example.employeemgmtspringmvc.controller;

import com.example.employeemgmtspringmvc.Model.entities.Employee;
import com.example.employeemgmtspringmvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", service.getAllEmployee());
        return "index";
    }

    @GetMapping("/newemployeeform")
    public String showemlpoyeeform(Model model) {
        model.addAttribute("employee", new Employee());
        return "new_employee";

    }

    @PostMapping("/saveemployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateform/{id}")
    public String updateForm(@PathVariable Long id, Model model) {

        model.addAttribute("employee1", service.getEmployeebyid(id));
        return "update_employee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        service.deleteEmployee(id);
        return "redirect:/";
}

}
