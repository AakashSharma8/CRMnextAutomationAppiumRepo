package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class tc_3940_login_logout extends BaseClass {

	@Test
	public void tc_3940_login_logout_func() throws IOException, InterruptedException {

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
			lp.enterusername().sendKeys("Akash");

			lp.enterpass().sendKeys("Apple_qa");

			lp.loginclick();

			loginPage logmsg = new loginPage(driver);

			WebDriverWait lg_msg = new WebDriverWait(driver, 1);
			lg_msg.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@text='Invalid User Name or Password.']")));

			String login_msg = logmsg.invalidUsnmPass().getText();
			Assert.assertEquals("Invalid User Name or Password.", login_msg);

			service.stop();

		} else {

			try {

				WebDriverWait wct = new WebDriverWait(driver, 10);
				wct.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")));
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

				lp.enterusername().sendKeys(String.valueOf("Akash"));

				lp.enterpass().sendKeys(String.valueOf("Apple_qa"));

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
					lg_msg.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//*[@text='Invalid User Name or Password.']")));

					String login_msg = logmsg.invalidUsnmPass().getText();
					Assert.assertEquals("Invalid User Name or Password.", login_msg);

					service.stop();
				}
			} catch (NullPointerException npe) {
				System.out.println("Input Strings can't be balnked");
			}
		}
	}
}
