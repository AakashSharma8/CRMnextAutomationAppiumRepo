package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.excel.lib.util.Xls_Reader;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class LeadLayoutopencheck_tc extends BaseClass {

	AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void StartAppiumDriver() throws IOException {
		System.out.println("Before Method");
		service = startServer();
		driver = capabilities("gold7app");

		Boolean isPresent = driver.findElements(MobileBy.xpath("//*[@text='ALLOW']")).size() > 0;

		if (isPresent) {

			driver.findElement(MobileBy.xpath("//*[@text='ALLOW']")).click();
		}

	}

	@AfterMethod
	void teardown() {
		driver.quit();
		service.stop();
	}

	@Test
	public void LeadCreate() throws InterruptedException {

		WebDriverWait wct = new WebDriverWait(driver, 10);
		wct.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")));

		continuePage cp = new continuePage(driver);
		cp.cont();

		WebDriverWait lgpage = new WebDriverWait(driver, 15);
		lgpage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='TxtName']")));
		loginPage lp = new loginPage(driver);

		lp.enterusername().sendKeys(String.valueOf("Akash"));

		lp.enterpass().sendKeys(String.valueOf("Apple_qa"));

		lp.loginclick();

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

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/fab")));

		LeadObject lo = new LeadObject(driver);
		lo.newbutton();

		WebDriverWait wait_ln = new WebDriverWait(driver, 15);
		wait_ln.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='QA Layout']")));

		LeadCategorylayout lc = new LeadCategorylayout(driver);
		lc.selectLayout();

		WebDriverWait wait_lc = new WebDriverWait(driver, 30);
		wait_lc.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		// getting lead layout data
		// getting lead layout data
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Akash Sharma\\Desktop\\selenium\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AppiumCRMpocAI\\src\\main\\java\\com\\excel\\lib\\util\\LeadLayoutInputs.xlsx");

		String name = reader.getCellData("LeadLayout", 1, 2);
		System.out.println(name);
		String title = reader.getCellData("LeadLayout", 1, 3);
		System.out.println(title);
		String rating = reader.getCellData("LeadLayout", 1, 4);
		System.out.println(rating);

		String product = reader.getCellData("LeadLayout", 1, 5);
		System.out.println(product);

		LeadLayout1 leadLyt1 = new LeadLayout1(driver);

		WebElement a = leadLyt1.entername();
		a.clear();
		a.sendKeys(name);

		leadLyt1.Title.sendKeys(title);

		leadLyt1.ratinglayout();

		WebDriverWait wait_rating = new WebDriverWait(driver, 10);
		wait_rating.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Warm']")));

		Utilities ratg = new Utilities(driver);
		ratg.scrollToText(rating).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 2);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		Utilities scrollprod = new Utilities(driver);
		scrollprod.scrollToText("Maruti").click();

		WebDriverWait wait_prod = new WebDriverWait(driver, 30);
		wait_prod.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Maruti']")));

		Utilities selectprod = new Utilities(driver);
		selectprod.scrollToText(product).click();

		leadLyt1.SaveLeadButton.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		Thread.sleep(3000);
	}

	@Test
	public void LeadUpdate() throws InterruptedException {

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

		LeadViewscategories recent = new LeadViewscategories(driver);

		recent.cat_qag.click();
		recent.firstlead_recent.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		LeadDetail ld = new LeadDetail(driver);
		ld.Editbutton.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 15);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		/*
		 * WebDriverWait wait_rating = new WebDriverWait(driver, 10);
		 * wait_rating.until(ExpectedConditions.presenceOfElementLocated(By.
		 * xpath("//*[@text='Hot']")));
		 */
		Utilities UpdateRating = new Utilities(driver);
		UpdateRating.scrollToText("Hot").click();
		Thread.sleep(2000);
		Utilities UpdateRating1 = new Utilities(driver);
		UpdateRating1.scrollToText("Warm").click();

		LeadLayout1 ld1 = new LeadLayout1(driver);
		ld1.SaveLeadButton.click();
		Thread.sleep(3000);

	}

	@Test
	public void quickSearch() {

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

		qs.quicksearchbutton.click();

		qs.quicksearchbutton.sendKeys("Akash");

		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

		WebDriverWait wait1 = new WebDriverWait(driver, 8);
		wait1.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.view.View[@content-desc = 'RedirectToBackPage?x=q7fcwhc6llt2d']")));

		LeadDetail ld = new LeadDetail(driver);
		String name = ld.Name.getText();
		SoftAssert sa = new SoftAssert();

		sa.assertEquals("akash", name);
		sa.assertAll();

	}

	@Test
	public void CreatedDataRecentVisibility() throws InterruptedException {

		/*
		 * WebDriverWait wct = new WebDriverWait(driver, 10);
		 * wct.until(ExpectedConditions.presenceOfElementLocated( By.xpath(
		 * "//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']"
		 * )));
		 * 
		 * continuePage cp = new continuePage(driver); cp.cont();
		 * 
		 * WebDriverWait lgpage = new WebDriverWait(driver, 15);
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

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/fab")));

		LeadObject lo = new LeadObject(driver);
		lo.newbutton();

		WebDriverWait wait_ln = new WebDriverWait(driver, 15);
		wait_ln.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='QA Layout']")));

		LeadCategorylayout lc = new LeadCategorylayout(driver);
		lc.selectLayout();

		WebDriverWait wait_lc = new WebDriverWait(driver, 30);
		wait_lc.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		// getting lead layout data
		// getting lead layout data
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Akash Sharma\\Desktop\\selenium\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AppiumCRMpocAI\\src\\main\\java\\com\\excel\\lib\\util\\LeadLayoutInputs.xlsx");

		String name = reader.getCellData("LeadLayout", 1, 2);
		System.out.println(name);
		String title = reader.getCellData("LeadLayout", 1, 3);
		System.out.println(title);
		String rating = reader.getCellData("LeadLayout", 1, 4);
		System.out.println(rating);

		String product = reader.getCellData("LeadLayout", 1, 5);
		System.out.println(product);

		LeadLayout1 leadLyt1 = new LeadLayout1(driver);

		WebElement a = leadLyt1.entername();
		a.clear();
		a.sendKeys(name);

		leadLyt1.Title.sendKeys(title);

		leadLyt1.ratinglayout();

		WebDriverWait wait_rating = new WebDriverWait(driver, 10);
		wait_rating.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Warm']")));

		Utilities ratg = new Utilities(driver);
		ratg.scrollToText(rating).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 2);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		Utilities scrollprod = new Utilities(driver);
		scrollprod.scrollToText("Maruti").click();

		WebDriverWait wait_prod = new WebDriverWait(driver, 30);
		wait_prod.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Maruti']")));

		Utilities selectprod = new Utilities(driver);
		selectprod.scrollToText(product).click();

		leadLyt1.SaveLeadButton.click();

		String lay = "QA Layout";
		String layout1 = "//android.view.View[@text='";
		String layout2 = "']";
		String xpath = layout1 + lay + layout2;

		System.out.println(xpath);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		Thread.sleep(6000);
		LeadDetail ld = new LeadDetail(driver);
		ld.backarrow.click();

		Thread.sleep(3000);

		LeadObject firstdata = new LeadObject(driver);

		System.out.println(firstdata.leaddata.size());
		for (int i = 1; i <= firstdata.leaddata.size(); i++) {

			// GetNamefromrecent
			String namepar1 = "//*[@index='";
			String namepar2 = "']/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView";
			String xpath1 = namepar1 + 2 + namepar2;

			WebElement fstdta = firstdata.leaddata.get(i).findElement(By.xpath(xpath1));

			List<String> allName = new ArrayList<String>();
			allName.add(fstdta.getText());
			// System.out.println(fstdta.getText());

			for (int j = 0; j <= allName.size(); j++) {
				System.out.println(allName.get(j));
			}
		}

		WebElement fstdta = firstdata.leaddata.get(1).findElement(
				By.xpath("//*[@index='2']/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));

		System.out.println(fstdta.getText());
		String nm = fstdta.getText();
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(nm, name);

	}

}
