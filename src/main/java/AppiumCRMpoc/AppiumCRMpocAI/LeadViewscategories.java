package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadViewscategories {

	public LeadViewscategories(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}


	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Recent']")
	public WebElement cat_qag;

	@FindBy(xpath = "//*[@text='00000982']")
	public WebElement firstlead_recent;

	public void customviewcategory() {

		cat_qag.click();

	}

}
