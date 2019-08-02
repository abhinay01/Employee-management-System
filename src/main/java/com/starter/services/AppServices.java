package com.starter.services;

import org.springframework.web.multipart.MultipartFile;

import com.starter.entity.Employee;

public interface AppServices {
	
	Iterable <Employee> listDetails();
	
	Employee getDetailById(Integer employee_id);
	
	Employee saveDetails(Employee employee);
	
	void deleteRecord(Integer id);

	void saveImage(MultipartFile imagefile, Employee employee) throws Exception;

	Employee getEmployeeByEmail(String email);

	Employee updateEmployee(Integer employee_id, String newEmail);

	boolean findPKey(Integer employee_id);
	
	

	

	

}
