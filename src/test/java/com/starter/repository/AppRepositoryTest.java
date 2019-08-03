package com.starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.starter.entity.Employee;
import com.starter.repository.AppRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AppRepository appRepository;
	
	@Test
	public void testSaveEmployee(){
		
		Employee employee = getEmployee();
		
		Employee savedInDb = entityManager.persist(employee);
		
		
		Employee getFromDb = appRepository.findOne(savedInDb.getEmployee_id());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	
	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployee_id(12121);
		employee.setFirst_name("Aditi");
		employee.setLast_name("Shah");
		employee.setEmail("aditishah@gmail.com");
		employee.setContact_number("7548624569");
		employee.setDob("22/01/1963");
		employee.setSex("Female");
		employee.setUnit("MFS");
		employee.setProfile_pic("aditi.jpg");
		employee.setAddress("RMZ,Banglore");
		employee.setDesignation("Engineer");
		employee.setCity("Banglore");
		employee.setDepartment("Development");
		employee.setPin("411005");
		return employee;
	}


@Test
public void testGetEmployeeById(){
	Employee employee = new Employee();
	employee.setEmployee_id(13131);
	employee.setFirst_name("Rucha");
	employee.setLast_name("Sharma");
	employee.setEmail("ruchasharma@gmail.com");
	employee.setContact_number("7545224569");
	employee.setDob("22/01/1967");
	employee.setSex("Female");
	employee.setUnit("CVS");
	employee.setProfile_pic("rucha.jpg");
	employee.setAddress("Shivajinagar,Pune");
	employee.setDesignation("Tech Lead");
	employee.setCity("Pune");
	employee.setDepartment("Engineer");
	employee.setPin("411056");
	//Save ticket in DB
	Employee employeeSavedInDb = entityManager.persist(employee);
	
	//Get Ticket from DB
	Employee employeeFromInDb = appRepository.findOne(employeeSavedInDb.getEmployee_id());
	assertThat(employeeSavedInDb).isEqualTo(employeeFromInDb);
  }



@Test
public void testDeleteEmployeeById(){
	Employee employee1 = new Employee();
	employee1.setEmployee_id(13131);
	employee1.setFirst_name("Rucha");
	employee1.setLast_name("Sharma");
	employee1.setEmail("ruchasharma@gmail.com");
	employee1.setContact_number("7545224569");
	employee1.setDob("22/01/1967");
	employee1.setSex("Female");
	employee1.setUnit("CVS");
	employee1.setProfile_pic("rucha.jpg");
	employee1.setAddress("Shivajinagar,Pune");
	employee1.setDesignation("Tech Lead");
	employee1.setCity("Pune");
	employee1.setDepartment("Engineer");
	employee1.setPin("411056");
	
	Employee employee2 = new Employee();
	employee2.setEmployee_id(12121);
	employee2.setFirst_name("Aditi");
	employee2.setLast_name("Shah");
	employee2.setEmail("aditishah@gmail.com");
	employee2.setContact_number("7548624569");
	employee2.setDob("22/01/1963");
	employee2.setSex("Female");
	employee2.setUnit("MFS");
	employee2.setProfile_pic("aditi.jpg");
	employee2.setAddress("RMZ,Banglore");
	employee2.setDesignation("Engineer");
	employee2.setCity("Banglore");
	employee2.setDepartment("Development");
	employee2.setPin("411005");
	
	//Save both tickets in DB
	Employee persist = entityManager.persist(employee1);
	entityManager.persist(employee2);
	
	//delete one ticket DB
	entityManager.remove(persist);
	
	Iterable<Employee> allEmployeesFromDb = appRepository.findAll();
	List<Employee> employeeList = new ArrayList<>();
	
	for (Employee employee : allEmployeesFromDb) {
		employeeList.add(employee);
	}
	assertThat(employeeList.size()).isEqualTo(1);
 }


}
