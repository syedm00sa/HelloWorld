package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository Repository;
	@RequestMapping("/greeting")
	public String Hello() {
	return "Hello Students #";
	}
	
	@GetMapping(value = "/employee")
	public Iterable<Employee> getAllEmployee(){
		Iterable<Employee> employeeCollection = Repository.findAll();
		return employeeCollection;
	}

	@GetMapping(value = "/employee", params = {"name"})
	public List<Employee> getStudent1(@RequestParam(value="name") String name) {
		 List<Employee> names = Repository.getNames(name);
		return names;
	}
	
	
	@RequestMapping(value = "/employee",method=RequestMethod.GET, params = {"id"})
	public Employee getStudent1(@RequestParam(value="id")long id) {
		Employee employee =new Employee();
		Optional<Employee> optionalEmployee = Repository.findById(id);
		if(optionalEmployee.isPresent()) {
			employee=optionalEmployee.get();
		}
		return employee;
	}

		
	@RequestMapping(value = "/employee",method=RequestMethod.DELETE)
	public Employee deleteEmployee(@RequestParam(value="id") long id) {
		Employee EmployeeToDelete =new Employee();
	Optional<Employee>optionalEmployee =Repository.findById(id);
	if (optionalEmployee.isPresent()) {
		EmployeeToDelete=optionalEmployee.get();
		Repository.deleteById(EmployeeToDelete.getId());
	}
	return EmployeeToDelete;
}

	
	@PostMapping(value = "/employee")
	public Employee createNewEmployee(@RequestBody Employee newEmployee) {
	return Repository.save(newEmployee);	    
	  }

	@PutMapping(value="/employee/{id}")
	public Employee replaceEmployee(	@RequestBody Employee employee)
			{
			Optional<Employee>optionalEmployee= Repository.findById(employee.getId());
			Employee Employee=new Employee();
			
			if(optionalEmployee.isPresent()) {
				Employee.setName(employee.getName());
				Employee.setSalary(employee.getSalary());
				Employee.setExperience(employee.getExperience());
				Employee.setAddress(employee.getAddress());
				Employee.setPhone_number(employee.getPhone_number());
				Employee.setNationality(employee.getNationality());
				Employee.setMartial_status(employee.getMartial_status());
				Employee.setEducation(employee.getEducation());
				Employee.setBlood_group(employee.getBlood_group());
				Employee.setCode(employee.getCode());
				Employee.setDateOfJoin(Employee.getDateOfJoin());
				
				Repository.save(employee);	
			}
			return Employee;
		}	
	
		 	
}

