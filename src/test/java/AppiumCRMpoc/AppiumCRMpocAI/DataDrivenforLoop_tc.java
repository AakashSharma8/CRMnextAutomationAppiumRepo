package AppiumCRMpoc.AppiumCRMpocAI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

public class DataDrivenforLoop_tc {

	@Test(dataProvider = "test1data")
	public void dataforloop(String usname, String password) {

		System.out.println(usname);
		System.out.println(password);

	}

	@DataProvider(name = "test1data")
	public Object[][] getData() {

		Object data[][] = testData();
		return data;

	}

	public Object[][] testData() {

		Xls_Reader r = new Xls_Reader(
				"C://Users//Akash Sharma//Desktop//selenium//eclipse-jee-mars-2-win32-x86_64//eclipse//AppiumCRMpocAI//src//main//java//com//excel//lib//util//LeadLayoutInputs.xlsx");

		int rows = r.getRowCount("Login");
		int coln = r.getColumnCount("Login");

		System.out.println(rows);
		System.out.println(coln);

		Object data[][] = new Object[rows - 1][coln];

		for (int i = 2; i <= rows; i++) {

			for (int j = 0; j < coln; j++) {

				String celldata = r.getCellData("Login", j, i);
				// System.out.println(celldata + " ");
				data[i - 2][j] = celldata;

			}

		}

		return data;

	}
}