package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadLayout1 {

	public LeadLayout1(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//android.view.View[@index = '6']/android.widget.EditText")
	public WebElement lastname1;

	@FindBy(xpath = "//android.view.View[@index = '8']/android.widget.EditText")
	public WebElement title;

	@FindBy(xpath = "//android.view.View[@index = '10']")
	public WebElement rating;

	@FindBy(xpath = "//android.view.View[@index = '28']")
	public WebElement product1;

	@FindBy(xpath = "//*[@text = 'Enter Name here']")
	public WebElement lastname;

	@FindBy(xpath = "//*[@text = 'Enter Title']")
	public WebElement Title;

	@FindBy(xpath = "//*[@text = 'Warm']")
	public WebElement ratingselect;

	@FindBy(xpath = "//*[@text = 'Maruti']")
	public WebElement product;

	@FindBy(xpath = "//*[@content-desc = 'Save']")
	public WebElement SaveLeadButton;

	public void ratinglayout() {

		ratingselect.click();

	}

	public WebElement entername() {

		return lastname;

	}

	public void productclick() {

		product.click();

	}

	public WebElement entertitle() {

		return Title;

	}

}