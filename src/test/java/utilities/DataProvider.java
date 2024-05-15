package utilities;

import java.io.IOException;

public class DataProvider {
	
	@org.testng.annotations.DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\OpenCart_LoginData.xlsx"; //testData\OpenCart_LoginData.xlsx
		
		ExcelUtility xutil = new ExcelUtility(path); //creating an object for XLUtility
		
		int rowCount = xutil.getRowCount("Sheet1");
		int cellCount = xutil.getCellCount("Sheet", 1);
		
		String[][] data = new String[rowCount][cellCount]; //created for two dimension array which can store the data user and password
		
		for(int r=1; r<= rowCount; r++) { //1   //read the data from xl storing in two deminsional array
			for(int c=0; c<cellCount;c++) {  //0    i is rows j is col
				data[r-1][c] = xutil.getCellData("Sheet1", r, c);
			}
		}
		return data; //returning two dimension array
	} 
	
	

}