package com.starter.selenium;



import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class EmployeeWeb {

	static WebDriver driver;
	
	@BeforeClass
	public static void BrowserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); 
	    driver= new ChromeDriver() ;
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Register_User() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"sticky-wrapper\"]/header/div/div/div[2]/nav/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"fname_id\"]")).sendKeys("Dinesh");
		driver.findElement(By.xpath("//*[@id=\"lname_id\"]")).sendKeys("Rathi");
		driver.findElement(By.xpath("//*[@id=\"dob_id\"]")).sendKeys("25/07/1997");
		driver.findElement(By.xpath("//*[@id=\"gender_id\"]")).sendKeys("Male");
		driver.findElement(By.xpath("//*[@id=\"eid_id\"]")).sendKeys("10101");
		driver.findElement(By.xpath("//*[@id=\"unit_id\"]")).sendKeys("Business");
		driver.findElement(By.xpath("//*[@id=\"branch_id\"]")).sendKeys("HR");
		driver.findElement(By.xpath("//*[@id=\"email_id\"]")).sendKeys("dinesh25@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"desg_id\"]")).sendKeys("Manager");
		driver.findElement(By.xpath("//*[@id=\"contact_id\"]")).sendKeys("5000124697");
		//driver.findElement(By.xpath("//*[@id=\"pic_id\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pic_id\"]")).sendKeys("D:\\spring-boot-final-new1111\\spring-boot-final-new\\spring-boot-final-new\\src\\main\\resources\\static\\images\\person_1.jpg");
		driver.findElement(By.xpath("//*[@id=\"add\"]")).sendKeys("RMZ,Banglore");
		driver.findElement(By.xpath("//*[@id=\"city_id\"]")).sendKeys("Banglore");
		driver.findElement(By.xpath("//*[@id=\"pin_id\"]")).sendKeys("411005");
		driver.findElement(By.name("submit")).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Thread.sleep(5000);
		
		 String str = driver.findElement(By.xpath("//*[@id=\"card_pad\"]/form/div/div[1]/label[1]")).getText();
		 if(str.equals("Search by Employee ID:"))
			 System.out.println("Success");
		String url= driver.getCurrentUrl();
		//assertEquals("fail- unable to register", url, "https://accounts.lambdatest.com/user/email-verification");
	
		}

	
	@AfterClass
	public static void BrowserClose()
	{
		
		driver.quit();
	}
	

	}