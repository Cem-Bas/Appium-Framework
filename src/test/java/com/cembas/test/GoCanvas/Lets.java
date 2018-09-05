package com.cembas.test.GoCanvas;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Lets extends BaseApp {

	On on = new On(driver);

	public void waitAndClick(WebElement element) {
		// add wait
		element.click();
	}

	public boolean isDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public void skipIntro() {
		waitAndClick(on.loginButton);
	}

	public void typeUsername(String name) {
		on.usernameBox.clear();
		on.usernameBox.sendKeys(name);
	}

	public void typePassword(String password) {
		on.passwordBox.sendKeys(password);
	}

	public void clickLogin() {
		waitAndClick(on.loginButton);
	}

	public void loginWith(String username, String password) {
		typeUsername(username);
		typePassword(password);
		clickLogin();
	}

	public void fillNameInfo(String fullName) {
		on.userRealName.sendKeys(fullName);
	}

	public void selectDropDownItem(String selection) {
		on.dropDownMenu.click();

		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ListView";

		switch (selection) {
		case "A":
			xpath = xpath + "/android.widget.TextView[2]";
			break;
		case "B":
			xpath = xpath + "/android.widget.TextView[3]";
			break;
		case "C":
			xpath = xpath + "/android.widget.TextView[4]";
			break;
		default:
			System.out.println("No selection.");
		}
		driver.findElement(By.xpath(xpath)).click();
	}

	public void checkTheBox() {
		on.checkBox.click();
	}

	public void pickDate(String date) {
		// open the date picker
		on.datePickerButton.click();

		// Requested Date
		String[] dateParts = date.split("/");
		int d = Integer.parseInt(dateParts[1]);
		int m = Integer.parseInt(dateParts[0]);
		// int y = Integer.parseInt(dateParts[2]);

		String month = "";

		switch (m) {
		case 1:
			month = "Jan";
			break;
		case 2:
			month = "Feb";
			break;
		case 3:
			month = "Mar";
			break;
		case 4:
			month = "Apr";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "Jun";
			break;
		case 7:
			month = "Jul";
			break;
		case 8:
			month = "Aug";
			break;
		case 9:
			month = "Sep";
			break;
		case 10:
			month = "Oct";
			break;
		case 11:
			month = "Nov";
			break;
		case 12:
			month = "Dec";
			break;
		}

		String[] monthParts = on.dateHeader.getText().split(" ");

		// String dayofweek = monthParts[0].substring(0, 3);
		String monthShort = monthParts[1];
		// String today = monthParts[2];

		List<WebElement> childs = on.monthView.findElements(By.xpath(".//*"));

		while (!monthShort.equals(month)) {
			// move to the next month
			on.nextButton.click();
			// pick the day
			childs.get(d).click();
			// Check the calendar
			monthParts = on.dateHeader.getText().split(" ");
			monthShort = monthParts[1];
		}
		// Confirm the date
		on.OKButton.click();
	}

	public void pickTime(String time) {
		on.timeButton.click();

		// Toggle the time mode
		on.timeToggle.click();

		String[] timeParts = time.split(":");

		// Select the hour
		String hour = timeParts[0];
		on.hourBox.clear();
		on.hourBox.sendKeys(hour);

		// Select the minute
		String minute = timeParts[1];
		on.minuteBox.clear();
		on.minuteBox.sendKeys(minute);

		// Confirm the time
		on.OKButton.click();

		driver.hideKeyboard();
	}

	public void drawSignature() {
		horizontalSwipeByPercentage(0.6, 0.3, 0.5);
		on.doneButton.click();
	}

	// Horizontal line by percentages
	@SuppressWarnings("rawtypes")
	public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * endPercentage);

		new TouchAction(driver).press(point(startPoint, anchor)).moveTo(point(endPoint, anchor)).release().perform();
	}

	public void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public void capturePhoto() {
		on.capturePhotoButton.click();

		on.cameraApp.click();

		on.takeImageButton.click();

		on.okayButton.click();
	}

}
