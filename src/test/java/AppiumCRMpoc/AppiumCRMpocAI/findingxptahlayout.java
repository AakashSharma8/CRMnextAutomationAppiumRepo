package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class findingxptahlayout extends BaseClass {

	@Test
	public void findingxpathLeadobject() throws IOException {

		service = startServer();
		AndroidDriver<WebElement> driver = capabilities("gold7app");

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

		WebDriverWait waituser = new WebDriverWait(driver, 20);
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

		WebElement titleTextbox = driver.findElement(By.xpath(
				"//android.view.View[@text='Title']//parent::android.view.View//following-sibling::android.view.View//android.widget.EditText"));
		System.out.println(titleTextbox.getText());
		titleTextbox.clear();

		titleTextbox.sendKeys("Title check box");

		LeadLayout1 ly1 = new LeadLayout1(driver);
		ly1.lastname1.sendKeys("Jessi Eperson");

		service.stop();

	}

}
