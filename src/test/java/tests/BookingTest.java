package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import drivers.BaseTest;
import pages.BookingPage;
import pages.SearchTrainPage;

public class BookingTest extends BaseTest{
	
	@Test
	public void initiateBooking() throws InterruptedException, IOException {
		
		 SearchTrainPage search = new SearchTrainPage(driver);
		 BookingPage booking = new BookingPage(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds((10)));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='OK']"))).click();
		 
		 search.enterSearchDetails("AMBALA CANT JN - UMB (AMBALA)","SHMATA VD KATRA - SVDK (Jammu)");
			
		 Thread.sleep(3000);
		 
		 booking.bookTrainForPassenger();
		 
		 booking.specificTrainDetail("12919");
		
	}

}
