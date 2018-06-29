package project.taskcompose_mail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Mailaction {
	WebDriver driver;

	WebElement clickbutton;

	public void login(String username, String psswrd) {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(psswrd);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("ztih__main_Mail__FOLDER_textCell")));

	}

	public void initiatedriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\salonitandon\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://webmail.qainfotech.com/");
	}

	public String getUserName() {
		Boolean condition = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"z_userName\"]")));
		String userName = driver.findElement(By.xpath("//*[@id=\"z_userName\"]")).getText();
//		String expectedName = "Saloni Tandon";
//		// System.out.println(userName);
//		if (userName.equals(expectedName)) {
//			condition = true;
//		}

		return userName;
	}

	public void composemail_withsubject(String username, String subject) {
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

		}
		driver.findElement(By.id("zb__NEW_MENU_title")).click();
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {

		}
		driver.findElement(By.id("zv__COMPOSE-1_to_control")).clear();
		driver.findElement(By.id("zv__COMPOSE-1_to_control")).sendKeys(username);
		driver.findElement(By.id("zv__COMPOSE-1_to_control")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("zv__COMPOSE-1_to_control")).clear();
		driver.findElement(By.id("zv__COMPOSE-1_subject_control")).sendKeys(subject);
		driver.switchTo().frame("ZmHtmlEditor1_body_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("hello");
		driver.switchTo().parentFrame();
		// System.out.println(subject);

		driver.findElement(By.cssSelector("#zb__COMPOSE-1__SEND_title")).click();
		

	}

	public void composemail_withoutsubject(String username, String subject) {
		composemail_withsubject("salonitandon@qainfotech.com", " ");
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

		}
		
		driver.findElement(By.cssSelector("#OkCancel_button2_title")).click();

//		Alert alert = driver.switchTo().alert();
//		alert.accept();

	}

}
