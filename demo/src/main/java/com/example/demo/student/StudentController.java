package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {

		student.setId(Long.valueOf(studentService.getStudents().size() + 1));
		studentService.addNewStudent(student);
		//System.out.println(student.toString());
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam("name") String name,
			@RequestParam("email") String email
	) throws IllegalAccessException {
		studentService.updateStudent(studentId,name,email);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId){
		studentService.deleteStudent(studentId);
	}
}
