package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.android.AndroidDriver;

public class LeadLayoutopencheck_tc extends BaseClass {

	@Test
	public void leadLayoutopened() throws IOException, InterruptedException {

		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		HamburgerDrawer hm = new HamburgerDrawer(driver);

		hm.getdrawer().click();

		WebDriverWait wait_lo = new WebDriverWait(driver, 30);
		wait_lo.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Lead_s']")));

		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Lead_s").click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/fab")));

		LeadObject lo = new LeadObject(driver);
		lo.newbutton();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait_ln = new WebDriverWait(driver, 30);
		wait_ln.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='China Traditional Aakash']")));

		LeadCategorylayout lc = new LeadCategorylayout(driver);
		lc.selectLayout();

		// driver.findElement(By.xpath(
		// "//android.widget.TextView[@text='Multilingual Layout']"));

		WebDriverWait wait_lc = new WebDriverWait(driver, 30);
		wait_lc.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@text='China Traditional Aakash']")));

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

		leadLyt1.title.clear();
		leadLyt1.title.sendKeys(title);

		leadLyt1.ratinglayout();

		WebDriverWait wait_rating = new WebDriverWait(driver, 30);
		wait_rating.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Select']")));
		
		
		Utilities ratg = new Utilities(driver);
		ratg.scrollToText(rating).click();
		
		/*Swipescreen ss = new Swipescreen(driver);
		ss.swipeBottomTop();
 */
		
		Utilities scrollprod = new Utilities(driver);
		scrollprod.scrollToText("Car-Loan").click();
		
		WebDriverWait wait_prod = new WebDriverWait(driver, 30);
		wait_prod.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Select']")));
		
		Utilities selectprod = new Utilities(driver);
		selectprod.scrollToText(product).click();

		// LeadRating ratingselect = new LeadRating(driver);
		// ratingselect.ratingpopup();

		// Swipescreen ss = new Swipescreen(driver);
		// ss.swipeBottomTop();

	}
}
