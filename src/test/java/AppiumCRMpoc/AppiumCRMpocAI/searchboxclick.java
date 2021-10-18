package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class searchboxclick extends BaseClass {

	@Test
	public void quickSearch() throws IOException, InterruptedException {

		// service.start();

		AndroidDriver<WebElement> driver = capabilities("gold7app");

		/*
		 * WebDriverWait wct = new WebDriverWait(driver, 10);
		 * wct.until(ExpectedConditions.presenceOfElementLocated( By.xpath(
		 * "//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']"
		 * )));
		 * 
		 * continuePage cp = new continuePage(driver); cp.cont();
		 * 
		 * WebDriverWait lgpage = new WebDriverWait(driver, 25);
		 * lgpage.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//*[@resource-id='TxtName']"))); loginPage lp = new
		 * loginPage(driver);
		 * 
		 * lp.enterusername().sendKeys(String.valueOf("Akash"));
		 * 
		 * lp.enterpass().sendKeys(String.valueOf("Apple_qa"));
		 * 
		 * lp.loginclick();
		 */

		WebDriverWait waituser = new WebDriverWait(driver, 15);
		waituser.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/iv_drawer']")));

		HamburgerDrawer hm = new HamburgerDrawer(driver);

		hm.getdrawer().click();

		WebDriverWait wait_lo = new WebDriverWait(driver, 5);
		wait_lo.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Lead 2']")));

		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Lead 2").click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Lead 2']")));

		LeadObject qs = new LeadObject(driver);
		qs.quicksearchbutton.click();

		qs.searchText.click();

		qs.searchText.sendKeys("Akash");

		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

		Thread.sleep(2000);
		QuickSearchPage qsp = new QuickSearchPage(driver);

		WebElement firsttitle = qsp.Leadlistviewdata.get(1).findElement(
				By.xpath("//*[@resource-id = 'com.crmnextmobile.crmnextofflineplay:id/itemTitleTextView']"));

		Thread.sleep(2000);
		
		String title = firsttitle.getText();
		System.out.println(title);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals("akash", title);
		sa.assertAll();

		firsttitle.click();
		Thread.sleep(7000);
		WebElement layoutname = driver.findElement(By.xpath(
				"//*[@content-desc='RedirectToBackPage?x=q7fcwhc6llt2d']/parent::android.view.View/following-sibling::android.view.View"));

		System.out.println(layoutname.getText());
	}

}
