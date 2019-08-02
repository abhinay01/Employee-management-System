package com.starter.controller.rest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starter.entity.Employee;
import com.starter.services.AppServiceImplementation;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AppControllerRest.class,secure = false)
public class AppControllerRestTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AppServiceImplementation appServiceImplementation;
	
	@Test
	public void testCreateEmployee() throws Exception {
		
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
		
		String inputInJson = this.mapToJson(employee);
		
		String URI = "/api/employees/create";
		
		Mockito.when(appServiceImplementation.saveDetails(Mockito.any(Employee.class))).thenReturn(employee);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void testGetEmployeetById() throws Exception {
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
		
		Mockito.when(appServiceImplementation.getDetailById(Mockito.anyInt())).thenReturn(employee);
		
		String URI = "/api/employees/employeeId/13131";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(employee);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void testGetAllBookedEmployees() throws Exception {

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
		
		Mockito.when(appServiceImplementation.listDetails()).thenReturn(employeeList);
		
		String URI = "/api/employees/allemployees";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(employeeList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	
	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
