package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	@DataProvider(name = "Data")
	String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "/Rest Assured_Swagger.xlsx";

		int rowNum = ExcelUtils.getRowCount(path, "Sheet1");
		int colCount = ExcelUtils.getCellCount(path, "Sheet1", 1);

		String apiData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				apiData[i - 1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
				// to avoid the header part we are using i-1 in two dimensional array													
			}
		}
		return apiData;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserName() throws IOException {

		String path = System.getProperty("user.dir") + "/Rest Assured_Swagger.xlsx";

		int rowNum = ExcelUtils.getRowCount(path, "Sheet1");

		String apiData[] = new String[rowNum];

		for (int i = 1; i <= rowNum; i++) {
				apiData[i - 1] = ExcelUtils.getCellData(path, "Sheet1", i, 1);
				// to avoid the header part we are using i-1 in one dimensional array													
			}
		
		return apiData;
	}
}
