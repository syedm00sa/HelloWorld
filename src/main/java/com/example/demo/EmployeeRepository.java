package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

@Query("select ln from Employee ln where ln.name like %:name% ")
public List<Employee>  getNames(
		String name);


}

