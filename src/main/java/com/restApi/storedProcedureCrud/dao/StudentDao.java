package com.restApi.storedProcedureCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restApi.storedProcedureCrud.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,Long>{

	
	
	
}


