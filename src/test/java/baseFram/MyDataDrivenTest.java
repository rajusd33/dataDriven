package baseFram;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDataDrivenTest extends ScriptBase{
	
	@Test(dataProvider="DP")
	public void validsignIn(String username, String password, String VerificationText){
	  //abercrombi().homepage().closepopup();
	  abercrombi().homepage().signin().click();
	  abercrombi().log().login(username, password);
	  abercrombi().log().submitButton().click();
	  abercrombi().log().verifySignIn(VerificationText);
	  myAfterMethod();
  }

	@DataProvider(name="DP")
	public String[][] getTestData() throws Exception{
		String filepath = "C:/Users/PaxoTech Student/Desktop/info.xlsx";
		abercrombi().dataReader().setExcelFile(filepath);
		String[][] data = abercrombi().dataReader().getExcelSheetData("Sheet1");
		return data;
	}
	

  
}	// end of class

