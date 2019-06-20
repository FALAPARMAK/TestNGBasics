package Homework;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TaskOrangeHRM  extends CommonMethods{
//	TC 2: OrangeHRM Add EmployeeStep 
//	1: Click on PIM link and Add EmployeeStep 
//	2: Provide Details and SaveStep 
//	3: Verify Employee is added
	
	
	
	String url="https://opensource-demo.orangehrmlive.com/";
	
	@BeforeMethod
	public void Start() {
		setUpDriver("chrome", url);
	}
	
	@Test
	public void Login() throws InterruptedException {
		driver.get(url);
		sendText(driver.findElement(By.id("txtUsername")), "Admin");
		sendText(driver.findElement(By.id("txtPassword")), "admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		//driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		
		//driver.findElement(By.id("menu_pim_addEmployee")).click();
		sendText(driver.findElement(By.id("firstName")), "Asha");
		sendText(driver.findElement(By.id("lastName")), "Ashaqwe");
		sendText(driver.findElement(By.name("employeeId")), "33");
		//driver.findElement(By.cssSelector("input[id='photofile']")).click();
	driver.findElement(By.id("chkLogin")).click();
	driver.findElement(By.id("user_name")).sendKeys("ASHAAA");
	driver.findElement(By.cssSelector("[id='user_password']")).sendKeys("123456789");
	driver.findElement(By.cssSelector("[id='re_password']")).sendKeys("123456789");
	
	
	
	

	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	selectValueFromDD(driver.findElement(By.cssSelector("select[id='status']")),"");
	//selectValueFromDD(driver.findElement(By.cssSelector("select[class='formInputText valid']")),"Disabled");
	driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
	
	
	
	
	
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	
//	
	List<WebElement>rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody /tr"));
	Thread.sleep(3000);
	for(WebElement element:rows) {
		rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody /tr"));
		Thread.sleep(1000);	
		
		//System.out.println(element.getText());
		
	if(	element.getText().contains("Asha")){
		Thread.sleep(1000);
			System.out.println("Employee added");
		}else {
			System.out.println("No new employee");
		}
	}
	
	
}
}
