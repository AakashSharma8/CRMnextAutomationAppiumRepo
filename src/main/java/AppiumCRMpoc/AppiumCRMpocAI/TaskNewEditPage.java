package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskNewEditPage {
	
	
	
	public TaskNewEditPage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//android.view.View[@content-desc='Today's date']/following-sibling::android.view.View")
	public WebElement startDatecalander ;

	@FindBy(xpath = "//android.view.View[@text='Start Date']/following-sibling::android.view.View/android.widget.EditText")
	public WebElement startdatetextbox ;
}
