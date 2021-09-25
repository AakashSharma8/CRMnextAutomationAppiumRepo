package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {

	public loginPage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//*[@resource-id='TxtName']")
	public WebElement username;

	@FindBy(xpath = "//*[@resource-id='TxtPassword']")
	public WebElement pass;
	
	@FindBy(xpath = "//*[@text='Login']")
	public WebElement login;

	public WebElement enterusername() {

		return username;

	}

	public WebElement enterpass() {

		return pass;

	}

	public void loginclick(){
		
		login.click();
	}
}
