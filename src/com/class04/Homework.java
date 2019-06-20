package com.class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Homework extends CommonMethods{
//	Identify Priority of Test Cases
	
//TC1: WebOrder Verify Successful Login ( )
//	Step 1: Open browser and navigate to WebOrderStep 2: Enter valid username, enter valid 
//	password and click on the  login buttonStep 3: Verify user successfully logged in
//TC 2: WebOrder Creating and verifying Users( )Step 1: Create Two users and fill out 
//	all the required fields Step 2: Verify that user one name appears within the table  
//	Step 3: Edit user one  and update user one’s State, assert the new updated 
//	State is displayed and save the changes. Step 4: Verify that user two name appears within the table 
//	Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save 
//	the changes.
//TC 3: WebOrder verifying Users( )    
//	Step 1 : Assert Both User one and User Two are displayedNote: Create BeforeClass and AfterClass 
//	annotations to open browser and logout from the application. 
//	The creation of users two should depend on the creation of users one.The validation both users 
//	should depend on the creation of both users. Create xml file and share a screenshot of the test.
	String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";
	
	@DataProvider
	public Object [][] Person(){
		
		Object [][] data=new Object[3][7];
		
		data[0][0]="Betul";
		data[0][1]="Ellis Street";
		data[0][2]="plano";
		data[0][3]="Tx";
		data[0][4]="890009";
		data[0][5]="1234567876566";
		data[0][6]="11/22";
		

		data[1][0]="Mehmet";
		data[1][1]="Ellis Street";
		data[1][2]="plano";
		data[1][3]="Tx";
		data[1][4]="890009";
		data[1][5]="1234567876566";
		data[1][6]="11/22";
		

		data[2][0]="Hafsa";
		data[2][1]="Ellis Street";
		data[2][2]="plano";
		data[2][3]="Tx";
		data[2][4]="890009";
		data[2][5]="1234567876566";
		data[2][6]="11/22";
		
		
		return data;
	}

	@BeforeClass
	public void SetUp() {
		setUpDriver("chrome", url);
	}
	@Test
	public void Login() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}	
	

	@Test(dataProvider="Person",dependsOnMethods="Login")
	public void AddPerson(String name,String street,String city,String state,String zip,String num,String date) {
		driver.findElement(By.xpath("//a[text()='Order']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
	selectValueFromDD(driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")),"FamilyAlbum");
	   

	}

	@AfterClass
	public void TearDown() {
		//driver.close(); 
	} 
	
	
}
