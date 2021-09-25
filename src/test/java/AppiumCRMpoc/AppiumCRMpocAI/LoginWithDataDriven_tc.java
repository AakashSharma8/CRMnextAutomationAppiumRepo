package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginWithDataDriven_tc extends BaseClass {

	@Test(dataProvider = "test1data")
	public void logintest(String usname, String password) throws IOException {

		service = startServer();

		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Boolean isPresent = driver.findElements(MobileBy.xpath("//*[@text='While using the app']")).size() > 0;

		if (isPresent) {
			driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();

			// driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SKIP']"))).click();

			// driver.findElement(By.xpath("//*[@text='SKIP']")).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			continuePage cp = new continuePage(driver);
			cp.cont();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			loginPage lp = new loginPage(driver);
			lp.enterusername().sendKeys(usname);

			lp.enterpass().sendKeys(password);

			lp.loginclick();

		} else {

			try {
				// System.out.println(usname);
				// System.out.println(password);

				// WebDriverWait waituser = new WebDriverWait(driver,2);
				// waituser.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));
				// AndroidDriver<WebElement> driver1 = capabilities("gold7app");

				loginPage lp = new loginPage(driver);

				lp.enterusername().sendKeys(String.valueOf(usname));

				lp.enterpass().sendKeys(String.valueOf(password));

				lp.loginclick();
				service.stop();

			} catch (NullPointerException npe) {
				System.out.println("Input Strings can't be balnked");
			}

		}

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
				System.out.println(celldata + "   ");
				data[i - 2][j] = celldata;

			}

		}

		return data;
	}

}
