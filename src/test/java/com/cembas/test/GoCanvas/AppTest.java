package com.cembas.test.GoCanvas;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppTest extends BaseApp {

	public AppTest(String testName) throws MalformedURLException, InterruptedException {

	}

	@Test
	public void mobileChallenge() throws MalformedURLException, InterruptedException {

		Lets lets = new Lets();
		
		On on = new On(driver);

		lets.skipIntro();

		lets.loginWith("qa+628@gocanvas.com", "canvas");
		
		lets.waitAndClick(on.SDETProjectName);
		
		lets.fillNameInfo("Cem Bas");
		
		lets.selectDropDownItem("B");
		
		lets.checkTheBox();
		
		//lets.capturePhoto();
		
		lets.pickDate("10/12/18");
		
		lets.pickTime("3:34");
		
		lets.scrollAndClick("Capture Signature");
		
		lets.drawSignature();
		
		
		Thread.sleep(60);

	}
}
