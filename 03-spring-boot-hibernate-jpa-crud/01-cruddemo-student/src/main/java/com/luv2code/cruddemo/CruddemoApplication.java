package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("All students are deleting");
		int numRows = studentDAO.deleteAll();
		System.out.println(numRows + " rows deleted");

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		studentDAO.delete(studentId);

		System.out.println("Student w/id: " + studentId + " is deleted.");

	}

	private void updateStudent(StudentDAO studentDAO){
		int studentId = 1;
		Student theStudent = studentDAO.findById(studentId);

		System.out.println("updating student");
		theStudent.setFirstName("Scooby");

		studentDAO.update(theStudent);

		System.out.println("Updated student: " + theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Akcay");
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for(Student theStudent : theStudents){
			System.out.println(theStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Kaan", "Akcay", "akcay.kaandeniz@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		int theID = tempStudent.getId();

		System.out.println("Retrieving student with id: " + theID );

		Student myStudent = studentDAO.findById(theID);

		System.out.println("Found the student: " + myStudent);



	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Kaan", "Akcay", "akcay.kaandeniz@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
		
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating 3 student objects...");

		Student tempStudent1 = new Student("Ece", "Maralcan", "ece.maralcan@gmail.com");
		Student tempStudent2 = new Student("Deniz", "Akçay", "deniz.akcay@gmail.com");
		Student tempStudent3 = new Student("John", "Doe", "john.doe@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId())
		;System.out.println("Saved student. Generated id: " + tempStudent3.getId());


	}
}
