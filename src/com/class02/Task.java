package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task extends CommonMethods {
//	TC 1: OrangeHRM Title Validation
//
//	TC 2: OrangeHRM Successful Login 
//	https://opensource-demo.orangehrmlive.com/
//	Please make sure to use the following:
//	 annotations:
//		@BeforeMethod
//		@AfterMethod
//		@Test
//
//	What would you do if you do not want to execute any specific test case?
//	What would you do if you want to execute any specific test case first?
	
	@BeforeMethod
	public void Enter() {
		String url="https://opensource-demo.orangehrmlive.com/";
		setUpDriver("chrome", url);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Right title");
		}else {
			System.out.println("Wrong title");
		}
	}
	@Test
	public void Login() {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("[id='btnLogin']")).click();
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
}
