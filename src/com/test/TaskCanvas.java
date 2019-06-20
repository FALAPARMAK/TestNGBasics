package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;
 
public class TaskCanvas  extends CommonMethods{
//	TC 1: Swag Lab Title and Login Verification
//@BeforeMethod should contain 
//	navigation to the URL and title verification
//	@Test should contain steps to 
//	login and “Product” word verification
//  @AfterMethod should logOut from the 
//	application and close the browser
	
	
	@BeforeMethod
	public void Enter() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		String title=driver.getTitle();
		String expectedTitle="SWAG LABS";
		if(title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is "+ title);
		}else {
			System.out.println("You are in wrong page");
		}
		
	}
	@Test
	
	public void Login() throws InterruptedException {                 //input#user-name
		driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("[class='btn_action']")).click();
		String labelName=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Thread.sleep(2000);
		if(labelName.equalsIgnoreCase("Products")) {
			System.out.println(labelName+" is displayed");
		}else {
			System.out.println(labelName+" is not displayed");
		}
	}
	
	@AfterMethod
	public void Close() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		Thread.sleep(3000);
		driver.close();
	}
	
}
