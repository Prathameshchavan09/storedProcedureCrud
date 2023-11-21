package com.restApi.storedProcedureCrud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restApi.storedProcedureCrud.dao.StudentDao;
import com.restApi.storedProcedureCrud.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;


@Service
public class StudentService{


	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	

	public Student createStudent(Student student, Long id, String city, String name, int salary ) {
        System.out.println("Service is called");
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("createStudent")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("city", city)
                .setParameter("salary", salary);

        query.execute();
		return studentDao.save(student);
        
    }
	

	public List<Student> getAllStudent(){
		StoredProcedureQuery query = em
        .createNamedStoredProcedureQuery("getAllStudent");
        
        query.execute();
        return studentDao.findAll();
        
	}


	 public Student getStudentById(long id) {
	        StoredProcedureQuery query = em
	        		.createNamedStoredProcedureQuery("getStudentById")
	                .setParameter("id", id);
	        
	        query.execute();
	        Optional<Student> optionalUser =studentDao.findById(id);
	        return optionalUser.get();
	        
	    }


	 @Transactional
	public int deleteStudent(long id) {
		
		   StoredProcedureQuery query = em
	        		.createNamedStoredProcedureQuery("deleteStudent")
	                .setParameter("id", id);
		   query.execute();
	        
		   int rowsAffectedProcedure =  query.executeUpdate();
	       studentDao.deleteById(id);
	       
	      return rowsAffectedProcedure;

	}
	 
	 
	 

	@Transactional
    public Student updateStudent(Long id, String name, String city, int salary) {
        StoredProcedureQuery query = em
                .createNamedStoredProcedureQuery("updateStudent")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("city", city)
                .setParameter("salary", salary);

        query.execute();

        Student existingStudent = studentDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

        existingStudent.setId(id);
        existingStudent.setName(name);
        existingStudent.setCity(city);
        existingStudent.setSalary(salary);

        return studentDao.save(existingStudent);
    }

}

