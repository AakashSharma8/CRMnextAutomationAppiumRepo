package AppiumCRMpoc.AppiumCRMpocAI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public static AppiumDriverLocalService service;

	public AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();

		}
		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<WebElement> capabilities(String appName) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Akash Sharma\\Desktop\\selenium\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AppiumCRMpocAI\\src\\main\\java\\AppiumCRMpoc\\AppiumCRMpocAI\\global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		File app = new File("src");
		File f = new File(app, (String) prop.get(appName));

		AndroidDriver<WebElement> driver;

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("device"));
		dc.setCapability("appPackage", "com.crmnextmobile.crmnextofflineplay");
		// dc.setCapability("appActivity", ".login.ActivityLogin t130");
		dc.setCapability("appActivity", ".qr.QrScannerActivity t50");
		dc.setCapability("noReset", true);

		dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, dc);

		return driver;

	}
}
