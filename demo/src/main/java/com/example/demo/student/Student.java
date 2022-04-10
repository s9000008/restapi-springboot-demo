package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="student")
public class Student {
	public Student() {
		
	}
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="dob")
	private LocalDate dob;
	@Transient
	@Column(name="age")
	private Integer age;
	public  Student(Long id,String name,String email,LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
		return "Student{" + 
					"id=" + id +
					", name='" + name + '\'' +
					", email='" + email + '\'' +
					", dob='" + dob + '\'' +
					", age='" + age + '\'' +
					"}";
	}
}
