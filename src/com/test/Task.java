package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task extends CommonMethods {
	   @BeforeMethod
	    public void setUp() {
	        String url="https://www.saucedemo.com/";
	        setUpDriver("chrome", url);
	    }
	@Test
	    public void logIn() {
	        sendText(driver.findElement(By.cssSelector("input#user-name")),"standard_user");
	        sendText(driver.findElement(By.cssSelector("input#password")),"secret_sauce");
	        driver.findElement(By.cssSelector("input[type='submit']")).click();
	        String text=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
	        if(text.equals("Products")) {
	            System.out.println("Product is ON");
	        }else {
	            System.out.println("Product is OFF");
	        }
	        
	    }
	    
	    @AfterMethod
	    public void Close() {
	        
	       driver.findElement(By.xpath("//button[@style=\"position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; opacity: 0; font-size: 8px; cursor: pointer;\"]")).click();
	        WebDriverWait wait=new WebDriverWait(driver,30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#logout_sidebar_link")));
	        driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();
	        driver.close();
	    }
}
