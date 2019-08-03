package com.starter.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.starter.entity.Employee;

public interface AppServices {
	
	Iterable <Employee> listDetails();
	
	Employee getDetailById(Integer employee_id);
	
	Employee saveDetails(Employee employee);
	
	void deleteRecord(Integer id);

	void saveImage(MultipartFile imagefile, Employee employee) throws Exception;
	
    boolean findPKey(Integer employee_id);
	
	

	

	

}
