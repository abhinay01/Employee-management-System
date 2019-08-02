package com.starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.starter.entity.Employee;

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
		employee.setEmployee_id(12);
		employee.setFirst_name("Asiya");
		employee.setLast_name("Mulla");
		employee.setEmail("letsgo@gmail.com");
		employee.setContact_number("7548624569");
		employee.setDob("22/01/1963");
		employee.setSex("Female");
		employee.setUnit("MFS");
		employee.setAddress("RMZ");
		employee.setDesignation("IT");
		employee.setCity("Pune");
		employee.setDepartment("Devp");
		employee.setPin("411005");
		return employee;
	}


@Test
public void testGetEmployeeById(){
	Employee employee = new Employee();
	employee.setEmployee_id(13);
	employee.setFirst_name("Rucha");
	employee.setLast_name("Sharma");
	employee.setEmail("letsgotohell@gmail.com");
	employee.setContact_number("7545224569");
	employee.setDob("22/01/1967");
	employee.setSex("Female");
	employee.setUnit("MDH");
	employee.setAddress("ZMR");
	employee.setDesignation("NonIT");
	employee.setCity("Delhi");
	employee.setDepartment("Engg");
	employee.setPin("411056");
	//Save ticket in DB
	Employee employeeSavedInDb = entityManager.persist(employee);
	
	//Get Ticket from DB
	Employee employeeFromInDb = appRepository.findOne(employeeSavedInDb.getEmployee_id());
	assertThat(employeeSavedInDb).isEqualTo(employeeFromInDb);
  }


@Test
public void testFindByEmail(){
	Employee employee = new Employee();
	employee.setEmployee_id(13);
	employee.setFirst_name("Rucha");
	employee.setLast_name("Sharma");
	employee.setEmail("letsgotohell@gmail.com");
	employee.setContact_number("7545224569");
	employee.setDob("22/01/1967");
	employee.setSex("Female");
	employee.setUnit("MDH");
	employee.setAddress("ZMR");
	employee.setDesignation("NonIT");
	employee.setCity("Delhi");
	employee.setDepartment("Engg");
	employee.setPin("411056");
	//Save ticket in DB
	entityManager.persist(employee);
	//Get ticket info from DB for specified email
	Employee getFromDb = appRepository.findByEmail("letsgotohell@gmail.com");
	assertThat(getFromDb.getFirst_name()).isEqualTo("Rucha");
 }

@Test
public void testDeleteEmployeeById(){
	Employee employee1 = new Employee();
	employee1.setEmployee_id(12121);
	employee1.setFirst_name("Asiya");
	employee1.setLast_name("Mulla");
	employee1.setEmail("letsgo@gmail.com");
	employee1.setContact_number("7548624569");
	employee1.setDob("22/01/1963");
	employee1.setSex("Female");
	employee1.setUnit("MFS");
	employee1.setAddress("RMZ");
	employee1.setDesignation("IT");
	employee1.setCity("Pune");
	employee1.setDepartment("Devp");
	employee1.setPin("411005");
	
	Employee employee2 = new Employee();
	employee2.setEmployee_id(13131);
	employee2.setFirst_name("Rucha");
	employee2.setLast_name("Sharma");
	employee2.setEmail("letsgotohell@gmail.com");
	employee2.setContact_number("7545224569");
	employee2.setDob("22/01/1967");
	employee2.setSex("Female");
	employee2.setUnit("MDH");
	employee2.setAddress("ZMR");
	employee2.setDesignation("NonIT");
	employee2.setCity("Delhi");
	employee2.setDepartment("Engg");
	employee2.setPin("411056");
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

@Test
public void testUpdateEmployee(){
	Employee employee = new Employee();
	employee.setEmployee_id(13131);
	employee.setFirst_name("Rucha");
	employee.setLast_name("Sharma");
	employee.setEmail("letsgotohell@gmail.com");
	employee.setContact_number("7545224569");
	employee.setDob("22/01/1967");
	employee.setSex("Female");
	employee.setUnit("MDH");
	employee.setAddress("ZMR");
	employee.setDesignation("NonIT");
	employee.setCity("Delhi");
	employee.setDepartment("Engg");
	employee.setPin("411056");
	//save Ticket info in DB
	entityManager.persist(employee);
	
	Employee getFromDb = appRepository.findByEmail("letsgotohell@gmail.com");
	//update Email Address
	getFromDb.setEmail("letsgo2000@gmail.com");
	entityManager.persist(getFromDb);
	
	assertThat(getFromDb.getEmail()).isEqualTo("letsgo2000@gmail.com");
  }
}
