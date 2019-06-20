package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TaskNewTours  extends CommonMethods{
	//@BeforeTest(groups="smoke")
	@BeforeMethod(alwaysRun=true, groups="Smoke")
	public void setIP() {
	    String url="http://newtours.demoaut.com/";
	    setUpDriver("chrome", url);
	    driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}
	    @Test (groups="Regression")
	public void contactinfo() {
	    sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "NameTest");
	    sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastNameTest");
	    sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTes");
	    sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
	    
	}
	    @Test (groups= {"smoke","Regression"})
	    public void maılıngınfo() {
	        sendText(driver.findElement(By.cssSelector("input[name='address1']")), "NameTest");
	        sendText(driver.findElement(By.cssSelector("input[name='city']")), "lastNameTest");
	        sendText(driver.findElement(By.cssSelector("input[name='state']")), "phoneTes");
	        sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "userTest");
	        
	    }
	    @Test(groups="smoke")
	    public void userInformation() {
	        sendText(driver.findElement(By.cssSelector("input#email")), "mustafa");
	        sendText(driver.findElement(By.cssSelector("input[name='password']")), "Bahar");
	        sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "Bahar");
	    driver.findElement(By.cssSelector("input[name='register']")).click();
	    }
	    
	//@AfterTest(groups="Regression")
	    @AfterMethod(alwaysRun=true, groups="Smoke")
	public void teardown() {
}
}