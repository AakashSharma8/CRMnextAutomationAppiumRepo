package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class gpsEnable_tc2 extends BaseClass {

	@Test
	public void gpsEnablecheck() throws IOException {

		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		HamburgerDrawer hm = new HamburgerDrawer(driver);

		hm.getdrawer().click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Settings").click();
		
		WebDriverWait wait_lc = new WebDriverWait(driver, 30);
		wait_lc.until(ExpectedConditions.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/switchButton_gps")));
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		SettingPage setting = new SettingPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		setting.getgps().click();
		
		String gpstmsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(" GPS toast messgae is  : " + gpstmsg);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Assert.assertEquals("GPS Started", gpstmsg);
	
	}

}
