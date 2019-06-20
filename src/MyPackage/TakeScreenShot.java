package MyPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import util.CommonMethods;

public class TakeScreenShot extends CommonMethods {
	
	public static void main(String[] args) {
		String url="https://syntaxtechs.com/";
		setUpDriver("chrome", url);
	
		
		driver.get(url);
		driver.manage().window().fullscreen();
		//TakesScreenshot take=(TakesScreenshot)driver;
		
		takeScreenshot("screenshoots","syntaxtechsphoto" );
	
//		File self=take.getScreenshotAs(OutputType.FILE);
//		
//		
//		try {
//		                                               dosya olusturuyor
//		FileUtils.copyFile(self, new File("screenshots/Syntax/SyntaxPage.jpg"));
//		
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
		driver.quit();
		
	}
}
