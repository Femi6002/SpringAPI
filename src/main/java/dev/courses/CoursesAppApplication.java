package dev.courses;

import dev.courses.controller.MainController;
import dev.courses.model.Student;
import dev.courses.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursesAppApplication {
	Student student = new Student();

	public static void main(String[] args) {
		SpringApplication.run(CoursesAppApplication.class, args);


	}



}
