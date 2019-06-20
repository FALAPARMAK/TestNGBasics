package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import util.CommonMethods;

public class taskOne extends CommonMethods{
 //String url="https://www.saucedemo.com/";

 @BeforeGroups
 public void setUP() {
     setUpDriver("chrome", "www.saucedemo.com");
 }
 
 @Test (groups = "Smoke")
 public void userOne() {
     sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
     sendText(driver.findElement(By.cssSelector("input.form_input")), "secret_sauce");
     driver.findElement(By.cssSelector("input.btn_action")).click();
 }
 
 @Test(groups = "Regression1")
 public void userTwo() {
     sendText(driver.findElement(By.cssSelector("input#user-name")), "problem_user");
     sendText(driver.findElement(By.cssSelector("input.form_input")), "secret_sauce");
     driver.findElement(By.cssSelector("input.btn_action")).click();
 }
 @Test (groups = "Regression2")
 public void userThree() {
     sendText(driver.findElement(By.cssSelector("input#user-name")), "performance_glitch_user");
     sendText(driver.findElement(By.cssSelector("input.form_input")), "secret_sauce");
     driver.findElement(By.cssSelector("input.btn_action")).click();
     
    
 }
 
 
 
 @AfterMethod
 public void tearDown() {
     driver.close();
 }
 
}
