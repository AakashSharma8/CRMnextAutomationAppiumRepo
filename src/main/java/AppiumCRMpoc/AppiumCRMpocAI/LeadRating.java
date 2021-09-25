package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadRating {

	public LeadRating(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	
	
	@FindBy(xpath = "//*[@text='Hot']")
	public WebElement ratingselectpopup;
	
	public void ratingpopup() {

		ratingselectpopup.click();
	}

}
