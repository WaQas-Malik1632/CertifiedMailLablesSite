package com.cml.qa.testcases;

import com.cml.qa.base.TestBaseClass;
import com.cml.qa.pages.LandingPageClass;
import com.cml.qa.pages.SignUpPageClass;
import com.cml.qa.utilities.TestUtil;
import com.cml.qa.utilities.TestUtil_mailinator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

public class LandingPageTest extends TestBaseClass {
	TestUtil util;
	SignUpPageClass signup;
	TestUtil_mailinator utilMailinator;
	LandingPageClass landPage;

	public LandingPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		util = new TestUtil();
		intialization();
		signup = new SignUpPageClass();
		signup.Precondition();
		signup.userRegistrationForm();
		utilMailinator = new TestUtil_mailinator();
		utilMailinator.MailinatorLinkVerificationAndLoginNewUser();
		landPage = new LandingPageClass();
	}

	@Test
	public void VerifyPageTitle() throws IOException {
		String LandingPageClassTitle=landPage.VerifyLandingPageUIElements();
		Assert.assertEquals(LandingPageClassTitle,"Certified Mail Labels");
	}

	@AfterMethod
	public void afterMethod() {
	}

}
