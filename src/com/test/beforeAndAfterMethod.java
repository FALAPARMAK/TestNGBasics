package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class beforeAndAfterMethod {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	
	@Test
	public void testMethodOne() {
System.out.println("test method one");
	}
	
	@Test
	public void testMethodTwo() {
		System.out.println("test method two");
	}
	
	@AfterMethod
	
	public void afterMethod() {
		System.out.println("after method");
	}

}
