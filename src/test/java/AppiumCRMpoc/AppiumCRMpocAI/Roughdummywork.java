package AppiumCRMpoc.AppiumCRMpocAI;

import com.excel.lib.util.Xls_Reader;

public class Roughdummywork {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Akash Sharma\\Desktop\\selenium\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AppiumCRMpocAI\\src\\main\\java\\com\\excel\\lib\\util\\LeadLayoutInputs.xlsx");

		String fisrtname = reader.getCellData("LeadLayout", 1, 2);
		String lastname = reader.getCellData("LeadLayout", 1, 3);

		System.out.println(fisrtname);

		System.out.println(lastname);// System.out.println("test");

		int rowcount = reader.getRowCount("LeadLayout");
		System.out.println("total  rows:  " + rowcount);
	
	
	}

}
