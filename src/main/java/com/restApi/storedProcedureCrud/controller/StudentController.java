package com.restApi.storedProcedureCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.storedProcedureCrud.model.Student;
import com.restApi.storedProcedureCrud.response.ResponseHandler;
import com.restApi.storedProcedureCrud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<Object> createUser(@RequestBody Student student) {

		try {

			System.out.println("Controller called");
			Student createdStudent = studentService.createStudent(student, student.getId(), student.getName(),
					student.getCity(), student.getSalary());

			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, createdStudent);
		} catch (Exception e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}

	}

	@GetMapping("/student")
	public ResponseEntity<Object> getAllStudent() {

		try {

			List<Student> getStudents = studentService.getAllStudent();
			return ResponseHandler.generateResponse("Succesfully done!", HttpStatus.OK, getStudents);

		}

		catch (Exception e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}

	}

	@RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudentById(@PathVariable("id") long id) {

		try {

			System.out.println("called GetByID controller");
			Student getStudentById = studentService.getStudentById(id);
			return ResponseHandler.generateResponse("Successfullt get the User!", HttpStatus.OK, getStudentById);

		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}

	}

	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") long id) {
		
		  try {
		  
		  System.out.println("called deleteStudent controller"); 
		  int rowsAffected = studentService.deleteStudent(id);
		  if (rowsAffected > 0) 
		  { 
			  return ResponseEntity.ok("Deleted user with ID: " + id + ". Rows affected: " + rowsAffected);
		  
		  } 
		  
		  else 
		  {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with ID: " + id);
		  
		  }
		  
		  }
		  
		  catch (Exception e) { return
		  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
		  body("Error occurred: " + e.getMessage());
		  
		  }
		 
		 
			
	
}


	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {

		try {
			System.out.println("called UpdateStudent controller");
			Student updatedStudent = studentService.updateStudent(id, student.getName(), student.getCity(),
					student.getSalary());
			return ResponseHandler.generateResponse("Succesfully Updated!", HttpStatus.OK, updatedStudent);

		}

		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}

	}

}
