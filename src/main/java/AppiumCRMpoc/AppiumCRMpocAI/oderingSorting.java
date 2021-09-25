package AppiumCRMpoc.AppiumCRMpocAI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class oderingSorting {

	public oderingSorting(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.crmnextmobile.crmnextofflineplay:id/action_sort']")).click();

	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.crmnextmobile.crmnextofflineplay:id/action_sort']")
	public WebElement sortbutton;

	public void sort() {
		sortbutton.click();

	}
}
