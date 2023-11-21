
package com.restApi.storedProcedureCrud.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createStudent",
                procedureName = "createStudent",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "salary", type = Integer.class)}
        ),
        
        @NamedStoredProcedureQuery(
                name = "getStudentById",
                procedureName = "getStudentById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                }
        ),
        
        @NamedStoredProcedureQuery(
                name = "getAllStudent",
                procedureName = "getAllStudent"
                
        ),
        
        
        @NamedStoredProcedureQuery(
                name = "deleteStudent",
                procedureName = "deleteStudent",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                }
        ),
        
      
        @NamedStoredProcedureQuery(
                name = "updateStudent",
                procedureName = "updateStudent",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "salary", type = Integer.class)}
        ),
        
        
        
})
public class Student {

    @Id
    private Long id;
    private String name;
    private String city;
    private int salary;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Student(Long id, String name, String city, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}

   
}
