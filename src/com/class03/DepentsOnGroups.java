package com.class03;

import org.testng.annotations.Test;

public class DepentsOnGroups {
	@Test(dependsOnMethods="two")
	public void one() {
		System.out.println("one test ");
	}
	
	@Test(dependsOnMethods="three")
	public void two() {
		System.out.println("two test ");
	}
	
	@Test
	public void three() {
		System.out.println("three test ");
	}

}

