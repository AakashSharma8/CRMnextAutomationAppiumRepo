package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.thread.Scheduler.Task;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.android.AndroidDriver;

public class TaskFromLeadDetail_tc extends BaseClass {
	@Test
	public void TaskcreationfromLeaddetail() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<WebElement> driver = capabilities("gold7app");

/*		WebDriverWait wct = new WebDriverWait(driver, 10);
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

		WebDriverWait waituser = new WebDriverWait(driver, 30);
		waituser.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@resource-id='com.crmnextmobile.crmnextofflineplay:id/iv_drawer']")));

*/

		HamburgerDrawer hm = new HamburgerDrawer(driver);

		hm.getdrawer().click();

		WebDriverWait wait_lo = new WebDriverWait(driver, 10);
		wait_lo.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Lead 2']")));

		Utilities scroll = new Utilities(driver);
		scroll.scrollToText("Lead 2").click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.crmnextmobile.crmnextofflineplay:id/fab")));

		LeadObject lo = new LeadObject(driver);
		lo.newbutton();

		WebDriverWait wait_ln = new WebDriverWait(driver, 20);
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

		leadLyt1.lastname1.sendKeys(name);

		leadLyt1.title.sendKeys(title);

		leadLyt1.rating.click();

		//WebDriverWait wait_rating = new WebDriverWait(driver, 10);
		//wait_rating.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Warm']")));

		Utilities ratg = new Utilities(driver);
		ratg.scrollToText(rating).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 2);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		Utilities scrollprod = new Utilities(driver);
		scrollprod.scrollToText("Product").click();

		leadLyt1.product1.click();

		Utilities selectprod = new Utilities(driver);
		selectprod.scrollToText(product).click();

		leadLyt1.SaveLeadButton.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='QA Layout']")));

		LeadDetail ld = new LeadDetail(driver);
		ld.relatedactivity.click();

		ld.threepin.click();

		Thread.sleep(2000);
		WebElement task = driver.findElement(By.xpath("//android.widget.TextView[@text='New Task']"));
		task.click();

		Thread.sleep(2000);
		TaskNewEditPage tsk = new TaskNewEditPage(driver);

		String date = reader.getCellData("Task", 1, 2);
		System.out.println(date);
		
		StringBuffer date1 = new StringBuffer(date);
		date1.insert(6,"20");
		tsk.startdatetextbox.sendKeys(date1);
		service.stop();
	}
}
