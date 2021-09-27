package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentRepository;
import com.example.demo.Student1;




@RestController
public class StudentController {
	
	
	@Autowired
	StudentRepository Repository1;
	@RequestMapping("/greeting")
	public String Hello() {
	return "Hello Students #";
	}
	
	@RequestMapping(value = "/student",method=RequestMethod.GET)
	public Iterable<Student1> getAllStudent(){
		Iterable<Student1> student1Collection = Repository1.findAll();
		return student1Collection;
	}
	@RequestMapping(value = "/student",method=RequestMethod.GET, params = {"id"})
	public Student1 getStudent1(@RequestParam(value="id")long id) {
		Student1 student1 =new Student1();
		Optional<Student1> optionalStudent1 = Repository1.findById(id);
		if(optionalStudent1.isPresent()) {
			student1=optionalStudent1.get();
		}
		return student1;
	}
	@RequestMapping(value = "/student")
	public Student1 addStudent1(@RequestParam(value="firstname") String firstname,
			@RequestParam(value="lastname") String lastname){
		Student1 newStudent1 =new Student1(firstname,lastname);
	    
		Repository1.save(newStudent1);
		return newStudent1;
	}
	@RequestMapping(value = "/student",method=RequestMethod.DELETE)
		public Student1 deleteStudent1(@RequestParam(value="id") long id) {
		Student1 student1ToDelete =new Student1();
		Optional<Student1>optionalStudent1 =Repository1.findById(id);
		if (optionalStudent1.isPresent()) {
			student1ToDelete=optionalStudent1.get();
			Repository1.deleteById(student1ToDelete.getId());
		}
		return student1ToDelete;
	
	}

	@RequestMapping(value="/student", method=RequestMethod.PUT)
	public Student1 editStudent1(@RequestParam(value="id")long id,
	@RequestParam(value="firstname")String firstname,
	@RequestParam(value="lastname")String lastname){
		Optional<Student1>optionalStudent1= Repository1.findById(id);
		Student1 student1=new Student1();
		if(optionalStudent1.isPresent()) {
			student1 =optionalStudent1.get();

			if (firstname != null && student1.getFirstname() !=firstname ) {
				student1.setFirstname(firstname);
			}
			if(lastname != null && student1.getLastname() !=lastname) {
				student1.setLastname(lastname);
			}
			Repository1.save(student1);	
		}
		return student1;
	}

	
}

