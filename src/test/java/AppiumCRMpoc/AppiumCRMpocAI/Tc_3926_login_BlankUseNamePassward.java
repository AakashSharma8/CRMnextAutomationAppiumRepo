package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Tc_3926_login_BlankUseNamePassward extends BaseClass {

	@Test(dataProvider = "test1data")
	public void tc_3926_loginwith_blank_user_pass(String usname, String password)throws IOException, InterruptedException {
		service = startServer();
		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Boolean isPresent = driver.findElements(MobileBy.xpath("//*[@text='ALLOW']")).size() > 0;

		if (isPresent) {

			driver.findElement(MobileBy.xpath("//*[@text='ALLOW']")).click();

			WebDriverWait wct = new WebDriverWait(driver, 10);
			wct.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")));

			continuePage cp = new continuePage(driver);
			cp.cont();
			WebDriverWait lgpage = new WebDriverWait(driver, 15);
			lgpage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));

			loginPage lp = new loginPage(driver);
			lp.enterusername().sendKeys(usname);

			lp.enterpass().sendKeys(password);

			lp.loginclick();
			
			loginPage logmsg = new loginPage(driver);
			
			WebDriverWait lg_msg = new WebDriverWait(driver, 1);
			lg_msg.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Invalid User Name or Password.']")));
			
			String login_msg = logmsg.invalidUsnmPass().getText();
			Assert.assertEquals("Invalid User Name or Password.", login_msg);
			
			service.stop();

		} else {

			try {


				WebDriverWait wct = new WebDriverWait(driver, 10);
				wct.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")));
				Boolean contisPresent = driver
						.findElements(MobileBy
								.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']"))
						.size() > 0;
				if (contisPresent) {

					continuePage cp = new continuePage(driver);
					cp.cont();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				}

				// @resource-id='TxtName'
				WebDriverWait lgpage = new WebDriverWait(driver, 15);
				lgpage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));
				loginPage lp = new loginPage(driver);

				lp.enterusername().sendKeys(String.valueOf(usname));

				lp.enterpass().sendKeys(String.valueOf(password));

				lp.loginclick();
				Thread.sleep(2000);
				Boolean uppresent = driver.findElements(By.xpath("//*[@text='Invalid User Name or Password.']"))
						.size() > 0;

				if (!uppresent) {

					WebDriverWait waituser = new WebDriverWait(driver, 15);
					waituser.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/iv_drawer']")));
					HamburgerDrawer hb = new HamburgerDrawer(driver);
					hb.drawer.click();
					hb.logout.click();
					service.stop();
				} else {
					loginPage logmsg = new loginPage(driver);
					
					WebDriverWait lg_msg = new WebDriverWait(driver, 1);
					lg_msg.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Invalid User Name or Password.']")));
					
					String login_msg = logmsg.invalidUsnmPass().getText();
					Assert.assertEquals("Invalid User Name or Password.", login_msg);
					
					
					service.stop();
				}

			} catch (NullPointerException npe) {
				System.out.println("Input Strings can't be balnked");
			}

		}

	}

	@DataProvider(name = "test1data")
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
