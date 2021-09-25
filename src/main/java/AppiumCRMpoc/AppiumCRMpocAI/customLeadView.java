package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class customLeadView {

	public customLeadView(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElement(By.xpath("//*[@text='Cust_lead 2']")).click();

	@FindBy(xpath = "//*[@text='All Active Lead_p']")
	public WebElement custview;

	public void customview() {

		custview.click();
	}
}
