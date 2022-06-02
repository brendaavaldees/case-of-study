package com.brenda.employmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brenda.employmentsystem.model.Compensation;
import com.brenda.employmentsystem.model.CompensationType;
import com.brenda.employmentsystem.model.Employee;
import com.brenda.employmentsystem.service.CompensationService;
import com.brenda.employmentsystem.service.CompensationTypeService;
import com.brenda.employmentsystem.service.EmployeeService;

@Controller
public class CompensationController {
	
	@Autowired
	private CompensationService compensationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompensationTypeService compensationTypeService;
	
	@GetMapping("/compensations/{employee_id}")
	public String viewCompensationsFromEmployee(@PathVariable (value = "employee_id") long employee_id, @Param("keyword") String keyword, Model model) {
		Employee employee = employeeService.getEmployeeById(employee_id);
		model.addAttribute("employee", employee);
		model.addAttribute("compensationList", compensationService.getCompensationsByEmployeeAndKeyword(employee, keyword));
		return "compensations.html";
	}
	
	@GetMapping("/addCompensation/{employee_id}")
	public String addCompensation(@PathVariable (value = "employee_id") long employee_id, Model model) {
		Employee employee = employeeService.getEmployeeById(employee_id);
		Compensation compensation = new Compensation(employee);
		CompensationType compensationType = new CompensationType();
		model.addAttribute("employee", employee);
		model.addAttribute("compensation", compensation);
		model.addAttribute("type", compensationType);
		model.addAttribute("typesList", compensationTypeService.getAllCompensationTypes());
		return "add-compensation.html";
	}
	
	@PostMapping("/saveCompensation/{employee_id}")
    public String saveCompensation(@PathVariable (value = "employee_id") long employee_id, Model model, @ModelAttribute("compensation")Compensation compensation) {
		Employee employee = employeeService.getEmployeeById(employee_id);
		model.addAttribute("employee", employee);
		compensationService.saveCompensation(compensation);
    	return "redirect:/compensations/{employee_id}";
    }
	
	@GetMapping("/editCompensation/{compensation_id}")
    public String editCompensation(@RequestParam (value = "employee_id") long employee_id, @PathVariable (value = "compensation_id") long compensation_id, Model model) {
    	Compensation compensation = compensationService.getCompensationById(compensation_id);
    	Employee employee = employeeService.getEmployeeById(employee_id);
    	model.addAttribute("employee", employee);
    	model.addAttribute("compensation", compensation);
    	model.addAttribute("typesList", compensationTypeService.getAllCompensationTypes());
    	return "edit-compensation.html";
    }

}
