package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class hamburgerscrollable_tc_1 extends BaseClass{

	@Test
	public void scrolling() throws IOException{
	AndroidDriver<WebElement> driver = capabilities("gold7app");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	HamburgerDrawer hm = new HamburgerDrawer(driver);
	
	hm.getdrawer().click();
	//WebElement menu = driver.findElementById("com.crmnextmobile.crmnextofflineplay:id/iv_drawer");
	
	System.out.println("Drawer open up");
	
 
	// Vertical Scrolling
	// Android api scrollingto a specific element - used android api into Appium

	
		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Settings");               
	

	/*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	MobileElement fulllist = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
			"new UiScrollable(new UiSelector()).scrollIntoView(" 
					+ "new UiSelector().text(\"Settings\"));"));  */
	

	
	System.out.println("Scrolled upto Setting successfully");
	
	
	
	//Hamburger list of objects
	/*List<WebElement> bd = driver.findElementsById("com.crmnextmobile.crmnextofflineplay:id/parent_view");
	System.out.println(bd.size());
	for (WebElement webelmt : bd) {

		WebElement bd3 = webelmt.findElement(By.xpath("//android.widget.TextView"));
		String name = bd3.getText();
		System.out.println(name);
	}*/

	//hm.getdrawer().click();	
	 
	}
}
