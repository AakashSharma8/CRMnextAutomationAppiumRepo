package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage {

	
	public SettingPage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(id="com.crmnextmobile.crmnextofflineplay:id/switchButton_gps")
	public WebElement gpsbutton;
	

	public WebElement getgps(){
		
		return gpsbutton;
		
	}
}

