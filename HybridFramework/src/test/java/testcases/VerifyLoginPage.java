package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Reusables;

public class VerifyLoginPage {
	WebDriver driver;
	Reusables reuse= new Reusables();
	LoginPage login;
	
	@BeforeTest
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\HybridFramework\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(reuse.readProperties("appURL"));
		System.out.println(reuse.readProperties("appURL"));
	}
	
	@Test
	public void verifyValidLogin() {
		login = new LoginPage(driver);
		login.loginPage();
	}
}
