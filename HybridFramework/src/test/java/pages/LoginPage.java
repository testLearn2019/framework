package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	Reusables reuse = new Reusables();
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	public void loginPage() {
		
		driver.findElement(By.id(reuse.readProperties("username"))).sendKeys(reuse.readExcel(0, 0));
		driver.findElement(By.id(reuse.readProperties("password"))).sendKeys(reuse.readExcel(0, 1));
		reuse.getScreenshot(driver,"invalidCrendentials");
		driver.findElement(By.id(reuse.readProperties("submitButton"))).click();
		reuse.getScreenshot(driver, "invalidCrendentialsResult");
		
		System.out.println("login over");
		
	}

}
