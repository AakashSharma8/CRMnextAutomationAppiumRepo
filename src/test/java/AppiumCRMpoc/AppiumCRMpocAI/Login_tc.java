package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Login_tc extends BaseClass {

	@Test
	public void logintest() throws IOException {

		AndroidDriver<WebElement> driver = capabilities("gold7app");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
		driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.findElement(MobileBy.xpath("//*[@text='While using the app']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.findElement(MobileBy.xpath("//*[@text='Allow']")).click();
		
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SKIP']"))).click();
		
	//	driver.findElement(By.xpath("//*[@text='SKIP']")).click();

		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		
		continuePage cp = new continuePage(driver);
		cp.cont();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginPage lp = new loginPage(driver);
		lp.enterusername().sendKeys("Akash");

		lp.enterpass().sendKeys("acid_qa");
		
		lp.loginclick();

	}

}
