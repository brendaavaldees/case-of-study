package com.brenda.employmentsystem.controller;

import com.brenda.employmentsystem.model.Employee;
import com.brenda.employmentsystem.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        model.addAttribute("employeesList", employeeService.getAllEmployees(keyword));
        model.addAttribute("keyword", keyword);
        return "home-page";
    }
    
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
    	Employee employee = new Employee();
    	model.addAttribute("employee", employee);
    	return "add-employee.html";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee) {
    	employeeService.saveEmployee(employee);
    	return "redirect:/home";
    }
    
    @GetMapping("/editEmployee/{employee_id}")
    public String editEmployee(@PathVariable (value = "employee_id") long id, Model model) {
    	Employee employee = employeeService.getEmployeeById(id);
    	model.addAttribute("employee", employee);
    	return "edit-employee.html";
    }
    
    @GetMapping("/deleteEmployee/{employee_id}")
    public String deleteEmployee(@PathVariable (value = "employee_id") long id) {
    	this.employeeService.deleteEmployeeById(id);
    	return "redirect:/home";
    }
    
    

}
