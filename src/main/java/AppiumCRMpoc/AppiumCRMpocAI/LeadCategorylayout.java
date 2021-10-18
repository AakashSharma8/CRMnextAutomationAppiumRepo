package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadCategorylayout {

	public LeadCategorylayout(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Multilingual Layout']"))
		
	@FindBy(xpath="//android.widget.TextView[@text='QA Layout']")
	public WebElement selectlayout;

	public void selectLayout() {

		selectlayout.click();
	}

}
