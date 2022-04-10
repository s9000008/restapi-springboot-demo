package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository
			) {
		return args ->{
			/*Student s1 = new Student(
					2L,"Andy","Andy@gmail.com",LocalDate.of(2020, 3, 19),18
					);
			Student s2 = new Student(
					3L,"Danny","Danny@gmail.com",LocalDate.of(2020, 3, 19),18
					);
			repository.saveAll(List.of(s1,s2));*/
		};
	}
}
