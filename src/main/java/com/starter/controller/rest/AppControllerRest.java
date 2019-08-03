package com.starter.controller.rest;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.starter.entity.Employee;
import com.starter.services.AppServiceImplementation;;

@RestController
@RequestMapping(value="/api/employees")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class AppControllerRest {

	@Autowired
	private AppServiceImplementation appServiceImplementation;
	
	@ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@CrossOrigin
	@GetMapping(value="/allemployees",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Employee> getAllBookedEmployees(){
		return appServiceImplementation.listDetails();
	}
	
	@ApiOperation(value = "Add an employee")
	@CrossOrigin
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee createEmployee( @Valid @RequestBody Employee employee){
		return appServiceImplementation.saveDetails(employee);
	}
	
	@ApiOperation(value = "Get an employee by Id")
	@CrossOrigin
	@GetMapping(value="/employeeId/{employeeId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById( @ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable("employeeId")Integer employeeId){
		return appServiceImplementation.getDetailById(employeeId);
	}
	

	
	
	@ApiOperation(value = "Delete an employee")
	@CrossOrigin
	@DeleteMapping(value="/employeeId/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId")Integer employeeId){
		appServiceImplementation.deleteRecord(employeeId);
	}
	

}
