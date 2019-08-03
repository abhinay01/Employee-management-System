package com.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.starter.entity.Employee;
import com.starter.services.AppServices;

@Controller
public class AppController {
	
	private AppServices appservice;

	@Autowired
	public void setAppservice(AppServices appservice) {
		this.appservice = appservice;
	}
	
	/* URL mapping done for adding a new Employee
	 * This mapping redirects it to Registration Form. */
	
	@RequestMapping("/addemployee")
	public String addDetails(Model model) {
		model.addAttribute("Employee", new Employee());
		return "regform";
	}
	
	/* This is the post Mapping done when the form on Registration page gets submitted. */
	
	@RequestMapping(value="detail",method=RequestMethod.POST)
	public String saveDetails( Employee employee, @RequestParam("imagefile") MultipartFile imagefile) {
		
		System.out.println(employee.getProfile_pic());
		
		if(appservice.findPKey(employee.getEmployee_id()))           /*Validation for employee_id so it will not have duplicate values.*/
		 	return "error";														   
		else
		{
			try {
				System.out.println("Inside try");
				appservice.saveImage(imagefile, employee);          /*Calling a separate function to save the image in an external folder present in src->main->resources->static->images and also in the database.*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		appservice.saveDetails(employee);
		System.out.println("54");
		return "redirect:/employee";
	}
	}
	
	/* URL Mapping done to display the list of all the Employees.
	 * It will redirect to HTML page where the detais have been shown fetched from database. */
	
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("Employee", appservice.listDetails());
		System.out.println("53");
		return "employees";
	}
	  
	
	/* URL Mapping done for searching by employee_id
	 * If not found then return error page
	 * else it will show the profile of the user found. */
	
	@RequestMapping("/detail/search_id")
	public String employee_byID(Model model,@RequestParam("emp_id") Integer emp_id ) {
		model.addAttribute("Employee", appservice.getDetailById(emp_id));
		if(appservice.findPKey(emp_id))
			return "profile";
		else
			return "error";
	}
	
	/* URL Mapping done to view the employee. */
	
	@RequestMapping("/detail/{employee_id}")
	public String employee_Details(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		System.out.println("56");
		return "profile";
	}
	
	
	/* URL mapping done to edit an employee_id.  */
	
	@RequestMapping("detail/edit/{employee_id}")
	public String editDetails(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		
		return "Update_prof";
	}
	
	/* URL Mapping done to delete an employee. */
	
	@RequestMapping("detail/delete/{employee_id}")
	public String deleteDetails(@PathVariable Integer employee_id) {
		appservice.deleteRecord(employee_id);
		return "redirect:/employee";
	}
	
	/* URL Mapping done to update the detail of the employee. */
	
	@RequestMapping(value="updateddetail",method=RequestMethod.POST)
	public String saveUpdatedDetails( Employee employee) {
	    
		System.out.println(employee.getProfile_pic());
		appservice.saveDetails(employee);
		return "redirect:/employee";
	}


}
