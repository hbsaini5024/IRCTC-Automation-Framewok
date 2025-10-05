package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By loginBtn = By.xpath("//a[@aria-label='Click here to Login in application']");
	By userName = By.xpath("//input[@placeholder='User Name']");
	By userPassword = By.xpath("//input[@placeholder='Password']");
	By signBtn = By.xpath("//input[@placeholder='User Name']/ancestor::form/descendant::button");
	By captchaInput = By.id("captcha");
	
	public void doLogin() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds((10)));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='OK']"))).click();
		
		 Assert.assertEquals(driver.getTitle(), "IRCTC Next Generation eTicketing System");
		
		driver.findElement(loginBtn).click();

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		
		username.sendKeys("*****");
		
		driver.findElement(userPassword).sendKeys("******");
		
		WebElement captchaInputField = driver.findElement(captchaInput);
		
		System.out.println("Waiting for the user to enter the captcha in the input Field ");
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Captcha here: ");
		String captcha = sc.nextLine();
		captchaInputField.sendKeys(captcha);
		
		driver.findElement(signBtn).click();
		
	}

}
