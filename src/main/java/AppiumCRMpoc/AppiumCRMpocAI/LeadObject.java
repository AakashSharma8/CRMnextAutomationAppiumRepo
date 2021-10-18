package AppiumCRMpoc.AppiumCRMpocAI;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeadObject {

	public LeadObject(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(id = "com.crmnextmobile.crmnextofflineplay:id/fab")
	public WebElement newbutton;

	@FindBy(id = "com.crmnextmobile.crmnextofflineplay:id/action_search")
	public WebElement quicksearchbutton;

	@FindBy(xpath = "//*[@resource-id ='com.crmnextmobile.crmnextofflineplay:id/search_src_text']")
	public WebElement searchText;

	@FindBy(xpath = "//*[@resource-id ='com.crmnextmobile.crmnextofflineplay:id/recycle_leads']//android.view.ViewGroup")
	public List<WebElement> leaddata;

	public void newbutton() {

		newbutton.click();

	}

}