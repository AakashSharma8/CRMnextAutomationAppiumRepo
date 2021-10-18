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

public class Tc_3934_showPassword extends BaseClass{
	@Test
	public void tc_3934_showPassword_func() throws IOException{
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
	
		lp.chkshow.click();
		Assert.assertEquals("Apple_qa",lp.pass.getText());;
		
		service.stop();
	}
	
	
}
