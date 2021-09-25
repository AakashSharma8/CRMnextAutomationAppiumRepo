package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import io.appium.java_client.android.AndroidDriver;

public class SortingButtoncheck_tc extends BaseClass{

	@Test
	public void sortingbuttontest() throws IOException {

		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		WebDriverWait w1 = new WebDriverWait(driver, 10);
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/iv_drawer")));
		
		HamburgerDrawer hm = new HamburgerDrawer(driver);

		hm.getdrawer().click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Lead_s").click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		LeadViewscategories lv = new LeadViewscategories(driver);
		lv.customviewcategory();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		customLeadView cv = new customLeadView(driver);
		cv.customview();
		//
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		customviewdata cd = new customviewdata(driver);
		cd.customdata();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		oderingSorting sb = new oderingSorting(driver);
		sb.sort();
		
	}
}
