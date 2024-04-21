package com.emp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.system.entity.Employee;
import com.emp.system.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp = empService.getAllEmp();
		m.addAttribute("emp", emp);
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);

		empService.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully!");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model m) {

		Employee e = empService.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {

		empService.addEmp(e);
		session.setAttribute("msg", "Employee Updated Successfully!");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id, HttpSession session) {

		empService.deleteEmp(id);
		session.setAttribute("msg", "Employee Data Deleted Successfully!");
		return "redirect:/";
	}
}
