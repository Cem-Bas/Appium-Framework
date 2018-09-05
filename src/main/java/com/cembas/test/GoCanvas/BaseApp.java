package com.cembas.test.GoCanvas;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class BaseApp

{
	static AndroidDriver<WebElement> driver;

	@BeforeClass
	public static void setup() {
		initDriver();
	}

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	protected static void initDriver() {
		System.out.println("Inside initDriver method");

		File app = new File("/Users/cem/Downloads/com.gocanvas_2018-08-13.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("deviceName", "98891a375732524831");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("appPackage", "com.gocanvas");
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.gocanvas.library.*");
		// cap.setCapability("noReset", true);

		String serverUrl = "http://127.0.0.1:4723/wd/hub";

		try {
			System.out.println("Argument to driver object : " + serverUrl);

			driver = new AndroidDriver<WebElement>(new URL(serverUrl), cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} catch (Throwable ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");
		}
		System.out.println("Driver in initdriver is : " + driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}