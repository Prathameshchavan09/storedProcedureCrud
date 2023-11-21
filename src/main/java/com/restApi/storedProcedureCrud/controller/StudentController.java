package com.restApi.storedProcedureCrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.restApi.storedProcedureCrud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {
        System.out.println("Controller called");
        studentService.createStudent(
                student.getId(),
                student.getName(),
                student.getCity(),
                student.getSalary()
        );
    }
    
    
    @GetMapping("/student")
    public List<Student> getAllStudent(){
    	
    	return studentService.getAllStudent();
    	
    }
    
    
    @RequestMapping(path="/student/{id}" ,method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") long id)
    {
    	
    	System.out.println("called GetByID controller");
    	return studentService.getStudentById(id);
    }
    
    
    
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") long id)
    {
    	
    	System.out.println("called deleteStudent controller");
    	studentService.deleteStudent(id);
    }
    
    

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable("id") long id ,@RequestBody Student student)
    {
    	
    	System.out.println("called UpdateStudent controller");
                 studentService.updateStudent(
                 id,
                 student.getName(),
                 student.getCity(),
                 student.getSalary()
         );
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
