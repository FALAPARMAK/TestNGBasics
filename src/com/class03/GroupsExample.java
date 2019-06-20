package com.class03;

import org.testng.annotations.Test;

public class GroupsExample {

	@Test(groups="Regression")
	public void one() {
		System.out.println("Test 1");
	}

	@Test(groups="Regression")
	public void Two() {
		System.out.println("Test 2");
	}

	@Test(groups="Smoke")
	public void onThree() {
		System.out.println("Test 3");
	}
	@Test(groups="Regression")
	public void Four() {
		System.out.println("Test 4");
	}
}
