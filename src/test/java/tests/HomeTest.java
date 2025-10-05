package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest{
	
	@Test
	public void validateHomeFunctionality() throws InterruptedException {
		
		HomePage home = new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds((10)));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='OK']"))).click();
		
		try {
			Assert.assertTrue(home.ChangeLanguageToHindi(), "Language is not getting changed to Hindi");
			
			Thread.sleep(4000);
			
			Assert.assertTrue(home.ChangeLanguageToEnglish(), "Language is not getting changed to English");
			
			Thread.sleep(4000);
			
			Assert.assertTrue(home.openPNRAndVerify(), "PNR page is not properly loaded or opened");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
