



package com.starter.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.starter.entity.Employee;
import com.starter.repository.AppRepository;

@Service
public class AppServiceImplementation implements AppServices {
	
	private AppRepository apprepository;
	
	@Autowired
	public void setApprepository(AppRepository apprepository) {
		this.apprepository = apprepository;
	}

	@Override
	public Iterable<Employee> listDetails() {
		
		return apprepository.findAll();
	}

	@Override
	public Employee getDetailById(Integer employee_id) {
		return apprepository.findOne(employee_id);
	}
	
	@Override
	public Employee saveDetails(Employee employee) {
		return apprepository.save(employee);
	}

	@Override
	public void deleteRecord(Integer employee_id) {
		apprepository.delete(employee_id);
	}
	
	@Override
	public Employee updateEmployee(Integer employee_id, String newEmail) {
		Employee employeeFromDb = apprepository.findOne(employee_id);
		employeeFromDb.setEmail(newEmail);
		Employee appendEmployee = apprepository.save(employeeFromDb);
		return appendEmployee;
	}
	
		@Override
	public void saveImage(MultipartFile imagefile, Employee employee) throws Exception {
		//File rootDir = new File("D:\\desktop\\training\\project\\final1.0\\spring-boot-app");
		
		//String folder="C:\\spring-boot-final-new\\spring-boot-final-new\\src\\main\\resources\\static\\images";
		System.out.println("USER "+System.getProperty("user.dir"));
		String sysPath=System.getProperty("user.dir");
		//String folder="D:\\desktop\\training\\project\\Employee-Management-System\\src\\main\\resources\\static\\images\\";
		String folder=sysPath+"\\\\src\\\\main\\\\resources\\\\static\\\\images\\\\";
		byte[] bytes=imagefile.getBytes();
		Path path = Paths.get(folder+imagefile.getOriginalFilename());
		System.out.println(path);
		Files.write(path,bytes);
		employee.setProfile_pic(imagefile.getOriginalFilename());
		//File uploadedFile = new File(rootDir, name);
		//file.transferTo(uploadedFile);
	}

	public boolean findPKey(Integer employee_id) {
		boolean employee_exist;
		employee_exist=apprepository.exists(employee_id);
		return employee_exist;
	}
	
	

}


