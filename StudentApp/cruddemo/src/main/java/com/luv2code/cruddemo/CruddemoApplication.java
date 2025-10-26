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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// using created methods to test the app
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// findAll(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		Student tempStudent = new Student("John", "Doe", "john.doe@mail.com");

		// save the student object
		studentDAO.save(tempStudent);

		// print created students id
		System.out.println("Student creation process succeeded, new Student id: " + tempStudent.getId());
	}

	public void createMultipleStudents(StudentDAO studentDAO) {
		// Creating more students to get more diverse data to work with
		Student tempStudent1 = new Student("Jane", "Doe", "jane.doe@mail.com");
		Student tempStudent2 = new Student("John", "Smith", "john.smith@mail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

	}

	private void readStudent(StudentDAO studentDAO) {
		// the code below is just a test, it would make more sense with I/O operations
		int id = 1;
		Student targetedStudent = studentDAO.findById(id);
		System.out.println("User with targeted id is: " + targetedStudent);
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("--------------------------------------------------------------");
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Smith");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Getting a student
		int studentId = 1; // It would also make sense to do I/O here
		Student student = studentDAO.findById(studentId);

		// Making some changes to the student
		student.setFirstName("Donald");

		// Updating the student
		studentDAO.update(student);

		// Displaying the student to prove the change
		System.out.println("Student updated: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}


}
