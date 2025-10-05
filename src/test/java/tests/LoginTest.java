package tests;

import org.testng.annotations.Test;

import drivers.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void makeLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		
		
		
		login.doLogin();
		
		Thread.sleep(3000);
	}

}
