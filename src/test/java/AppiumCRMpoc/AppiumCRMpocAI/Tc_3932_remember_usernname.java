package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Tc_3932_remember_usernname extends BaseClass {
	@Test
	public void Tc_3932_remember_usernname_func() throws IOException {

		service = startServer();
		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

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

		WebDriverWait lgpage = new WebDriverWait(driver, 15);
		lgpage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));
		loginPage lp = new loginPage(driver);

		lp.enterusername().sendKeys(String.valueOf("Akash"));

		lp.enterpass().sendKeys(String.valueOf("Apple_qa"));

		lp.checkbox.click();

		lp.loginclick();
		WebDriverWait menu = new WebDriverWait(driver, 25);
		menu.until(ExpectedConditions
				.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/iv_drawer")));

		HamburgerDrawer hd = new HamburgerDrawer(driver);
		hd.drawer.click();
		hd.logout.click();
		WebDriverWait lgpage2 = new WebDriverWait(driver, 15);
		lgpage2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));

		loginPage lp1 = new loginPage(driver);

		String usnm = lp1.username.getText();
		Assert.assertEquals("Akash", usnm);
		service.stop();
	}

}
