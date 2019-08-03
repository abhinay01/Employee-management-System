package com.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//@RequestMapping("/error")
	//public String errorPrint()
	//{
	//	return "error";
	//}
	
	@RequestMapping("/addemployee")
	public String addDetails(Model model) {
		model.addAttribute("Employee", new Employee());
		return "regform";
	}
	
	
	@RequestMapping(value="detail",method=RequestMethod.POST)
	public String saveDetails( Employee employee, @RequestParam("imagefile") MultipartFile imagefile) {
		
		System.out.println(employee.getProfile_pic());
		
		if(appservice.findPKey(employee.getEmployee_id()))
				return "error_regform";
		else
		{
			try {
				System.out.println("Inside try");
				appservice.saveImage(imagefile, employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		appservice.saveDetails(employee);
		System.out.println("54");
		return "redirect:/employee";
	}
	}
	
	
	
	
	@RequestMapping(value="detail/update_pic",method=RequestMethod.POST)
	public String savepic( Employee employee, @RequestParam("imagefile") MultipartFile imagefile)
	{
		
		System.out.println(employee.getEmployee_id());		
		
		Employee emp_pic = appservice.getDetailById(employee.getEmployee_id());
		
			try {
				System.out.println("Inside try");
				appservice.saveImage(imagefile, emp_pic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("image saved .. now saving database");
		System.out.println(employee.getEmployee_id());

		appservice.saveDetails(emp_pic);
		System.out.println("database saved..");

		System.out.println("54");
		return "redirect:/detail/"+ employee.getEmployee_id();
	
	}
	
	
	
	
	
	
//	@RequestMapping("detail/new")
//	public String addDetails(Model model) {
//		model.addAttribute("Employee", new Employee());
//		return "regform";
//	}
//	
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("Employee", appservice.listDetails());
		System.out.println("53");
		return "employees";
	}
	
	
//	@RequestMapping(value="/detail/search_id",method=RequestMethod.GET)
//	public String list(Model model) {
//		model.addAttribute("Employee", appservice.listDetails());
//		System.out.println("59");
//		return "employees";
//	}
	
	
	

//	@RequestMapping(value="detail",method=RequestMethod.POST)
//	public String saveDetails(Employee employee) {
//		appservice.saveDetails(employee);
//		System.out.println("54");
//		return "products";
//	}
	
//	@RequestMapping(value="detail",method=RequestMethod.POST)
//	public String saveDetails(Employee employee) {
//		appservice.saveDetails(employee);
//		System.out.println("54");
//		return "index";
//	}
	
	@RequestMapping("/detail/search_id")
	public String employee_byID(Model model,@RequestParam("emp_id") Integer emp_id ) {
		model.addAttribute("Employee", appservice.getDetailById(emp_id));
		if(appservice.findPKey(emp_id))
			return "profile";
		else
			return "error";
	}
	
	
	@RequestMapping("/detail/{employee_id}")
	public String employee_Details(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		System.out.println("56");
		return "profile";
	}
	
	@RequestMapping("detail/edit/{employee_id}")
	public String editDetails(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		return "Update_prof";
	}
	
	@RequestMapping("detail/delete/{employee_id}")
	public String deleteDetails(@PathVariable Integer employee_id) {
		appservice.deleteRecord(employee_id);
		return "redirect:/employee";
	}
	
	/*
	 * @GetMapping("/employee") public String employeeSearch(Model model) {
	 * model.addAttribute("Employee",new Employee());
	 * 
	 * return "employees"; }
	 * 
	 * @PostMapping("/employee") public String employeeSearch(Employee
	 * employee,Model model,String designation) { Employee foundEmployee =
	 * appservice.getDetailByDesignation(designation);
	 * model.addAttribute("Employee",foundEmployee);
	 * 
	 * return "employees";
	 * 
	 * }
	 */
	
	
	@RequestMapping(value="updateddetail",method=RequestMethod.POST)
	public String saveUpdatedDetails( Employee employee) {
	
//		try {
//			System.out.println("Inside try");
//			appservice.saveImage(imagefile, employee);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(employee.getProfile_pic());
		
		appservice.saveDetails(employee);
		System.out.println("54");
		return "redirect:/detail/" + employee.getEmployee_id();
	}


}
