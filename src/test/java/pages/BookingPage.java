package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BookingPage {
	
	WebDriver driver;
	
	public BookingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	
	By calendar = By.id("journeyDate");
	By dateOfBooking = By.xpath("//a[text()='16']");
	By modifySearchBtn = By.xpath("//button/span[text()='Modify Search']");
	By bookNowBtn = By.xpath("(//div[@class='form-group no-pad col-xs-12 bull-back border-all']/descendant::button[text()=' Book Now '])[1]");
	By sleeperBtn = By.xpath("(//div/strong[text()='Sleeper (SL)'])[1]");
	
	
	public void bookTrainForPassenger() throws InterruptedException {
		
		driver.findElement(calendar).click();
		
		driver.findElement(dateOfBooking).click();
		
		driver.findElement(modifySearchBtn).click();
		
		Thread.sleep(3000);
		
	}
	
	public void specificTrainDetail(String trainNumber) throws IOException, InterruptedException {
		
		String xpath1 = "//div[@class='col-sm-5 col-xs-11 train-heading']/strong[contains(text(),'" + trainNumber + "')]/parent::div/following-sibling::div/descendant::span[contains(text(),'Train Schedule')]";
		
		driver.findElement(By.xpath(xpath1)).click();
		
		Thread.sleep(3000);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("src/test/java/utils/" + trainNumber + ".png");
		FileUtils.copyFile(src, dest);
		
				
	}
	
	
}
