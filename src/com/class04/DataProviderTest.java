package com.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider
	public  Object[][]setUpData(){
		Object[][] data=new Object [3][2];
		
		data[0][0]="Tim";
		data[0][1]="Jon";
		
		data[1][0]="Tom"; 
		data[1][1]="Sam";
		
		data[2][0]="Will";
		data[2][1]="Smith";
		
		return data;
	}
	
	@Test(dataProvider="setUpData")
	public void getData(String first, String last) {
		System.out.println(first+last);
	}
	

}
