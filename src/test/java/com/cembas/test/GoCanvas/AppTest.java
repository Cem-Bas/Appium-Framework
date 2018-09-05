package com.cembas.test.GoCanvas;

import org.testng.annotations.Test;

public class AppTest extends BaseApp {

	@Test
	public void mobileChallenge() {
		Lets lets = new Lets();
		On on = new On(driver);

		lets.skipIntro();

		lets.loginWith("qa+628@gocanvas.com", "canvas");

		on.SDETProjectName.click();

		lets.fillNameInfo("Cem Bas");

		lets.selectDropDownItem("B");

		lets.checkTheBox();

		lets.capturePhoto();

		lets.pickDate("10/12/18");

		lets.pickTime("3:34");

		lets.scrollAndClick("Capture Signature");

		lets.drawSignature();
	}
}
