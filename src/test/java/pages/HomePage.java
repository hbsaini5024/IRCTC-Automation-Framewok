package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By LanguageBtn = By.xpath("//a[@aria-label='Click here to Login in application']/following-sibling::a[10]");
	By bookingTicketLabel = By.xpath("//label[@class='heading-font']");
	
	By PNRStatusBtn = By.xpath("(//a[@aria-label='PNR Status opens a new window'])[1]/label");
	By ChartsVacanyBtn = By.xpath("(//a[@aria-label='Reservation Chart. Website will be opened in new tab'])[1]/label");
	
	By PNRStatusLabel = By.xpath("//div[@class='col-md-8 col-md-push-2 text-center']/h3");
	By ReservationChart = By.xpath("//h6[text()='RESERVATION CHART']");
	
	public Boolean ChangeLanguageToHindi() {
		
		driver.findElement(LanguageBtn).click();
		
		return driver.findElement(bookingTicketLabel).getText().equals(" टिकट आरक्षण ") || driver.findElement(bookingTicketLabel).getText().equals("टिकट आरक्षण");
	}
	
	public Boolean ChangeLanguageToEnglish() {
		
		driver.findElement(LanguageBtn).click();
		
		return driver.findElement(bookingTicketLabel).getText().equals(" BOOK TICKET ") || driver.findElement(bookingTicketLabel).getText().equals("BOOK TICKET");
	}
	
	
	
	public Boolean openPNRAndVerify() {
		
		driver.findElement(PNRStatusBtn).click();
		
		String currWindowHandle = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window : windowHandles) {
			
			if(!window.equals(currWindowHandle)) {
				driver.switchTo().window(window);
				return driver.findElement(PNRStatusLabel).getText().contains("INDIAN RAILWAYS PASSENGER RESERVATION ENQUIRY");
			}
			
		}
		return false;
		
	}
	

}
