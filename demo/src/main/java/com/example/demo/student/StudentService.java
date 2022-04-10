package com.example.demo.student;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	private final StudentRepository studentRepository;
	
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		//return List.of(new Student(1L, "ban", "ban@gmail.com", LocalDate.of(2022, 3, 16), 25));
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) throws IllegalAccessException {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()){
			throw new IllegalAccessException("email is exist");
		}
		studentRepository.save(student);
		System.out.println(student);
	}
	@Transactional
	public void updateStudent(Long studentId,String name,String email) throws IllegalAccessException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(
						() -> new IllegalArgumentException("student with id " + studentId + "does not exist")
				);
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(student.getName(), name)){
			student.setName(name);
		}
		if(email != null &&
				email.length() > 0 &&
				!Objects.equals(student.getEmail(), email)){
					Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
					if(studentOptional.isPresent()){
						throw new IllegalAccessException("email is exist");
					}
					student.setEmail(email);
		}



	}

	public void deleteStudent(Long studentId){
		boolean exists = studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalArgumentException("student with id " + studentId + "does not exists");
		}
		studentRepository.deleteById(studentId);
	}
	
}
