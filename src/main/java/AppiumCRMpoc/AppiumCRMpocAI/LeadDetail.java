package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadDetail {

	public LeadDetail(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//android.view.View[@content-desc='Edit']")
	public WebElement Editbutton;

	@FindBy(xpath = "//android.view.View[@content-desc='RedirectToBackPage?x=q7fcwhc6llt2d']")
	public WebElement backarrow;

	@FindBy(xpath = "//*[@text ='Name']/following-sibling::android.view.View")
	public WebElement Name;

	@FindBy(xpath = "//android.view.View[@text='tab 2']")
	public WebElement relatedactivity;

	@FindBy(xpath = "//android.view.View[@text='Open Activities']/following-sibling::android.view.View")
	public WebElement threepin;
	
}
