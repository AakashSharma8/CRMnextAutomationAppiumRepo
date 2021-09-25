package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class customviewdata {

	public customviewdata(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='com.crmnextmobile.crmnextofflineplay:id/fab_view_detail']//android.widget.ImageButton")).click();

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.crmnextmobile.crmnextofflineplay:id/fab_view_detail']//android.widget.ImageButton")
	public WebElement custdata;

	public void customdata() {

		custdata.click();
	}
}
