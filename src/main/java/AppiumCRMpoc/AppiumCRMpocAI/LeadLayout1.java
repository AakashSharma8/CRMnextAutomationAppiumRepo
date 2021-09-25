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

	//@FindBy(xpath = "//*[@text='All Active Lead_p']")
	@FindBy(xpath = "//*[@text = 'Enter Name']")
	public WebElement lastname; 
	
	@FindBy(xpath = "//*[@text = 'Enter Title']")
	public WebElement title;
	
	@FindBy(xpath = "//*[@text = 'Warm']")
	public WebElement ratingselect;
	
	@FindBy(xpath = "//*[@text = 'Car-Loan']")
	public WebElement product;
	


	public void ratinglayout(){
		
		ratingselect.click();
		
	} 
	
	public WebElement entername(){
		
		return lastname;
		
	}
	
	public void productclick(){
		
		product.click();
	
	}
}