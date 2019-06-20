package com.class04;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import util.CommonMethods;


public class TaskSmartBear  extends CommonMethods{
//
//http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx
//
//TC 1: WebOrder Verify Successful Login ( )
//Step 1: Open browser and navigate to WebOrder
//Step 2: Enter valid username, enter valid password and click on the  login button
//Step 3: Verify user successfully logged in
//
//TC 2: WebOrder Creating and verifying Users( )
//Step 1: Create Two users and fill out all the required fields
// Step 2: Verify that user one name appears within the table 
// Step 3: Edit user one  and update user one’s State, assert the new updated State is displayed and save the changes.
// Step 4: Verify that user two name appears within the table 
// Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.
//
//TC 3: WebOrder verifying Users( )
//        Step 1 : Assert Both User one and User Two are displayed
//
//Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. The creation of users two should depend on the creation of users one.The validation both users should depend on the creation of both users. Create xml file and share a screenshot of the test.


String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";
@BeforeClass
public void SetUP() {
	setUpDriver("chrome", url);
}

@Test
public void Login() {
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Web Orders']")).isDisplayed(),true);
	
}


@Test(dependsOnMethods="Login")
public void WebOrder() {
	driver.findElement(By.xpath("//a[text()='Order']")).click();
	selectValueFromDD(driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")),"FamilyAlbum");
	sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")), "70");
	sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")), "50");
	driver.findElement(By.xpath("//input[@value='Calculate']")).click();
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Sam");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("NewYork Street");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Dallas");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Tx");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("80808");
	driver.findElement(By.xpath("//label[text()='MasterCard']")).click();
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4567674523211223");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/2020");
	driver.findElement(By.xpath("//a[text()='Process']")).click();
	driver.findElement(By.partialLinkText("View all orders")).click();
	
	//Assert.assertEquals(driver.findElement(By.partialLinkText("New order has been successfully added.")).isDisplayed(), true);
	
}
@Test(dependsOnMethods="WebOrder")
public void WebOrder2() {
	driver.findElement(By.xpath("//a[text()='Order']")).click();
	selectValueFromDD(driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")),"FamilyAlbum");
	sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")), "70");
	sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")), "50");
	driver.findElement(By.xpath("//input[@value='Calculate']")).click();
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Sally");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Town Street");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Plano");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Tx");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("76808");
	driver.findElement(By.xpath("//label[text()='MasterCard']")).click();
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("9087674523211223");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("11/2020");
	driver.findElement(By.xpath("//a[text()='Process']")).click();
	driver.findElement(By.partialLinkText("View all orders")).click();
	
	//Assert.assertEquals(driver.findElement(By.partialLinkText("New order has been successfully added.")).isDisplayed(), true);
	

	
	
	
	TakesScreenshot photo=(TakesScreenshot)driver;
	File selfie=photo.getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(selfie, new File("screenshots/smartbearsoftware.jpg"));
	}catch(IOException e) {
		e.printStackTrace();
		System.out.println("Selfie not taken");
	}


}





@AfterClass
public void TearDown() {
	driver.close();
} 

}