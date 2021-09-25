package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class HamburgerDrawer {

	public HamburgerDrawer(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElementById("com.crmnextmobile.crmnextofflineplay:id/iv_drawer");
	@FindBy(id = "com.crmnextmobile.crmnextofflineplay:id/iv_drawer")
	public WebElement drawer;

	
	@FindBy(xpath = "//android.widget.TextView[@text='Leads_P']")
	public WebElement lead;
	
	public WebElement getdrawer(){
		
		return drawer;
		
	}
	
	public void leadobject() {

		lead.click();
	}
	
}
