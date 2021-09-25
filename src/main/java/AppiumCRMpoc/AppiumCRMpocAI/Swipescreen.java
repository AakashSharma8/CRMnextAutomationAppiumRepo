package AppiumCRMpoc.AppiumCRMpocAI;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Swipescreen {

	AndroidDriver<WebElement> driver;

	public Swipescreen(AndroidDriver<WebElement> driver) {

		this.driver = driver;

	}

	public void swipeBottomTop() {

		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.75);
		int endy = (int) (size.height * 0.25);
		int startx = size.width / 2;
		System.out.println("Start swipe operation" + startx + endy + startx);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(startx, endy)).release().perform();

	}

}
