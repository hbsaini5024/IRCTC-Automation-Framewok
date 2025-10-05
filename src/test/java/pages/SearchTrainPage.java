package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchTrainPage {
	
	WebDriver driver;
	
	public SearchTrainPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By sourceInputfield = By.xpath("//input[@role='searchbox']/ancestor::p-autocomplete[@id='origin']/descendant::input");
	By destinationInputField = By.xpath("//input[@role='searchbox']/ancestor::p-autocomplete[@id='destination']/descendant::input");
	
	By SearchBtn = By.xpath("//button[@label='Find Trains']");
	By numberOfTrains = By.xpath("//div[@class='hidden-xs']/span");
	
//	Filtering
	By sortByDurationBtn = By.xpath("//button[text()=' Sort By ']");
	By EarlyFirstBtn = By.xpath("//button[text()='Duration']/child::span[text()='Early First']");
	By LateFirstBtn = By.xpath("//button[text()='Duration']/child::span[text()='Late First']");
	By AcChairCarCheckBox = By.xpath("//input[@id='CC']/following-sibling::label");
	By EcChairCarCheckBox = By.xpath("//input[@id='EC']/following-sibling::label");
	
	public void enterSearchDetails(String source, String destination) {
		
		driver.findElement(sourceInputfield).sendKeys(source);
		
		driver.findElement(destinationInputField).sendKeys(destination);
		
		driver.findElement(SearchBtn).click();
		
	}
	
	public void CountTrains() {
		
		String trainCountStr = driver.findElement(numberOfTrains).getText();
		System.out.println(trainCountStr);
		
		System.out.println("Total Trains are  : " + trainCountStr.split(" ")[0]);
	}
	
	public void applyFilterByDuration() {
		
		driver.findElement(sortByDurationBtn).click();
		
		driver.findElement(LateFirstBtn).click();
		
	}
	
	public void applyFilterByCategory() {
		
		driver.findElement(AcChairCarCheckBox);
		driver.findElement(EcChairCarCheckBox);
		
	}
	

}
