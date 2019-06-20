package Homework;



import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class OrangeHRM extends CommonMethods {


	
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
		Assert.assertEquals(driver.findElement(By.cssSelector("a#welcome")).isDisplayed(), true);
		System.out.println("Successfully login");
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys("Hakan");
		driver.findElement(By.id("lastName")).sendKeys("Snow");
		
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.cssSelector("[id='user_name']")).sendKeys("snow");
		driver.findElement(By.id("user_password")).sendKeys("12345678");
		driver.findElement(By.id("re_password")).sendKeys("12345678");
		
		
		WebElement status= driver.findElement(By.cssSelector("select[id='status']"));
		//selectValueFromDD(driver.findElement(By.cssSelector("select[id='status']")), 1);
		Select select=new Select(status);
		List<WebElement>options=select.getOptions();
		Thread.sleep(2000);
		//System.out.println(options.size());
		//driver.findElement(By.cssSelector("input[id='btnSave']")).click();
		Iterator<WebElement>it=options.iterator();
		
		while(it.hasNext()) {
			String text=it.next().getText(); 
			System.out.println(text);
		}
		
		select.selectByVisibleText("Disabled");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id='btnSave']")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		

	     
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody /tr"));
		Thread.sleep(3000);
		for(WebElement element:rows) {
			rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody /tr"));
			Thread.sleep(1000);	
			
			//System.out.println(element.getText());
			
		if(	element.getText().contains("Hakan")){
			Thread.sleep(1000);
				System.out.println("New Employee : "+element.getText());
			}
		}
//     OR ASSERT
//		 Assert.assertEquals(text, "0100 Helen  Snow");
//	       System.out.println("Employee details are displayed");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File self=ts.getScreenshotAs(OutputType.FILE);
		
		//FileUtils.copyFile()
		
}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}