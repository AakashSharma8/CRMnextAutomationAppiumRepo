package AppiumCRMpoc.AppiumCRMpocAI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utilities {

	AndroidDriver<WebElement> driver;

	public Utilities(AndroidDriver<WebElement> driver) {

		this.driver = driver;
	}

	public MobileElement scrollToText(String text) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement fulllist = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
		return fulllist;
		
	}

}
