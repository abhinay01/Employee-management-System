package com.starter.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.starter.entity.Employee;
import com.starter.repository.AppRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceImplementationTest {

	@Autowired
	private  AppServiceImplementation appServiceImplementation;
	
	@MockBean
	private AppRepository appRepository;
	
	@Test
	public void testCreateEmployee(){

		Employee employee = new Employee();
		employee.setEmployee_id(12121);
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
		
	    Mockito.when(appRepository.save(employee)).thenReturn(employee);
	    
	    assertThat(appServiceImplementation.saveDetails(employee)).isEqualTo(employee);
	
	}
	
	
	@Test
	public void testGetEmployeeById(){
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
		
	    Mockito.when(appRepository.findOne(13131)).thenReturn(employee);
	    assertThat(appServiceImplementation.getDetailById(13131)).isEqualTo(employee);
	}
	
	@Test
	public void testGetAllBookedEmployee(){
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
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		Mockito.when(appRepository.findAll()).thenReturn(employeeList);
		
		assertThat(appServiceImplementation.listDetails()).isEqualTo(employeeList);
	}
	
	
	@Test
	public void testDeleteEmployee(){
		Employee employee = new Employee();
		employee.setEmployee_id(12121);
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
		
	    Mockito.when(appRepository.findOne(1)).thenReturn(employee);
	    Mockito.when(appRepository.exists(employee.getEmployee_id())).thenReturn(false);
	   assertFalse(appRepository.exists(employee.getEmployee_id()));
	}
	
	
	//@Test
	/*public void testUpdateEmployee(){
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
		
		Mockito.when(appRepository.findOne(13131)).thenReturn(employee);
		
		employee.setEmail("letsgo@gmail.com");
		Mockito.when(appRepository.save(employee)).thenReturn(employee);
		
		assertThat(appServiceImplementation.updateTicket(1, "martin.s2017@gmail.com")).isEqualTo(ticket);
		
	}*/
	
	@Test
	public void testGetEmployeeByEmail(){
		
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
		
	    Mockito.when(appRepository.findByEmail("letsgotohell@gmail.com")).thenReturn(employee);
	    
	    assertThat(appServiceImplementation.getEmployeeByEmail("letsgotohell@gmail.com")).isEqualTo(employee);
	}
	
}
