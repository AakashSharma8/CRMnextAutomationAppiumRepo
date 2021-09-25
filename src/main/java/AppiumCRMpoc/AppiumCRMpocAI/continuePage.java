package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class continuePage {

	public continuePage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")).click();
	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.crmnextmobile.crmnextofflineplay:id/relative_layout_continue']")
	public WebElement continuebutton;

	public void cont() {

		continuebutton.click();
	}
}
