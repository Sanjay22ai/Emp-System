package com.emp.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.system.entity.Employee;
import com.emp.system.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	public void addEmp(Employee e) {
		empRepo.save(e);
	}

	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	public Employee getEmpById(int id) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}
