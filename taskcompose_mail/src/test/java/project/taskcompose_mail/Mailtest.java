package project.taskcompose_mail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Mailtest {
	Mailaction mailaction = new Mailaction();

	@Test(priority = 0)
	public void logintest() {
		String un = "salonitandon";
		String pw = "Saloni@321#";
		mailaction.login(un, pw);
	}

	@Test(priority = 1)
	public void checkLoginSuccessfull() {
		Assert.assertEquals(mailaction.getUserName(), "Saloni Tandon");
		//Assert.assertTrue(mailaction.loginValid());
	}

	@Test(priority = 2)
	public void checkcomposemail_withsubject() {		
		mailaction.composemail_withsubject("salonitandon@qainfotech.com", "mail test");
		//Assert.assertEquals(composemail_withsubject("salonitandon@qainfotech.com", "mail test"),"Message Sent");
	}

	@Test(priority = 3)
	public void checkcomposemail_withoutsubject() {
		mailaction.composemail_withoutsubject("salonitandon@qainfotech.com","mail test");
	}

	@BeforeClass
	public void launchBrowser() {
		mailaction.initiatedriver();

	}

	@AfterClass
	public void closeBrowser() {
		// driver.quit();

	}
}
