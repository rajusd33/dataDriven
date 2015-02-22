package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Log {

	WebDriver driver;
	public Log(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void login(String email, String password){
		WebElement emailBox = driver.findElement(By.xpath("//body/div/div/div/div/div/div/form/div/ul/li/input[@id='login-email-field']"));
		highlightElement(emailBox);
		emailBox.sendKeys(email);
		WebElement passBox = driver.findElement(By.xpath("//body/div/div/div/div/div/div/form/div/ul/li/input[@id='login-password-field']"));
		highlightElement(passBox);
		passBox.sendKeys(password);
	}
	
	public WebElement submitButton(){
		WebElement button = driver.findElement(By.xpath("//body/div[5]/div[1]/div/div/div[1]/div[1]/form/div[2]/ul/li/a/span/span/span/span"));
		highlightElement(button);
		return button;
	}
	
	public void verifySignIn(String HEYNAME){
		WebElement signinText = driver.findElement(By.xpath("//body/header/div/div/ul/li[@id='util-account']/a"));
		String Text = signinText.getText(); 
		highlightElement(signinText);
		Assert.assertEquals(HEYNAME, Text);
	}
	
	public void VerifyLogout(){
		//verify logout if signin webelement is present
		WebElement signin= driver.findElement(By.xpath("//body/div/header/div/div/ul/li[@id='util-account']/a"));
		highlightElement(signin);
		String signinText = signin.getText();
		Assert.assertEquals("SIGN IN", signinText);
	}
	
	
	
	public WebElement heyLink(){
		WebElement hey = driver.findElement(By.xpath("html/body/header/div/div/ul/li[@id='util-account']/a[@class='util-main']"));
		highlightElement(hey);
		return hey;
	}
	public WebElement logoutLink(){
		WebElement link = driver.findElement(By.xpath("html/body/header/div[2]/div/ul/li[2]/div/div/div[1]/div[@class='util-account-sign-out']/a"));
		highlightElement(link);
		return link;		
	}


	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: yellow; border: 2px solid yellow;");
			delayFor(200);
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
	
	
}	// end of signin page
