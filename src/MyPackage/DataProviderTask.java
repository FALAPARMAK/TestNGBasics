package MyPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTask {

  @DataProvider
  public Object [][] setUpData(){
	  Object[][]obj= new Object[3][3]; 

	  obj[0][0]="Asude";
	  obj[0][1]="Alaparmak";
	  obj[0][2]=16;
	
	  obj[1][0]="Ali";
	  obj[1][1]="Alaparmak";
	  obj[1][2]=10;
	  
	  obj[2][0]="Tarik";
	  obj[2][1]="Alaparmak";
	  obj[2][2]=8;
	
	return obj;
}

  
  @Test(dataProvider="setUpData")
	public void getObje(String first, String last,int age) {
	  System.out.println(first+last+age);
  }
	
}
