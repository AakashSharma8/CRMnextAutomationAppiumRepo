package AppiumCRMpoc.AppiumCRMpocAI;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuickSearchPage {

	public QuickSearchPage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//*[@resource-id = 'com.crmnextmobile.crmnextofflineplay:id/list_item_recycler']")
	public List<WebElement> Leadlistviewdata;

	@FindBy(xpath = "//*[@resource-id = 'com.crmnextmobile.crmnextofflineplay:id/itemTitleTextView']")
	public WebElement viewName;

	

}
