package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import drivers.BaseTest;
import pages.SearchTrainPage;

public class SearchTrainTest extends BaseTest{
	
	

	@Test(dataProvider = "searchTrains")
	public void searchYourTrain(String source, String destination) throws InterruptedException {
		
		SearchTrainPage search = new SearchTrainPage(driver);
		
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds((10)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='OK']"))).click();
		
		search.enterSearchDetails(source,destination);
		
		Thread.sleep(3000);
		
		search.CountTrains();
		
	}
	
	@DataProvider(name = "searchTrains")
	public Object[][] getData() {
	    return new Object[][] {
	        {"AMBALA CANT JN - UMB (AMBALA)", "SHMATA VD KATRA - SVDK (Jammu)	"},
	        {"AMBALA CANT JN - UMB (AMBALA)", "HARIDWAR JN - HW (HARIDWAR))"},
	        {"KURUKSHETRA JN - KKDE ","JAIPUR JN - JP (JAIPUR)"}
	    };
	}

	
	
}
