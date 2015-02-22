package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.google.common.base.Function;

public class Homepage {
	
	protected WebDriver driver;

	public Homepage(WebDriver driver){
		this.driver=driver;
	}
	
	 protected void ClickJS(WebElement element){
	 		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
	 }
	 
	 
	public void closeoffer(){
	//	WebElement closeSign;
		
		//WebElement closesignstrip = driver.findElement(By.xpath("//*[@id='home']/div/div/div[@class='header__gms-wrapper']"));
		
		//closeSign=driver.findElement(By.xpath("//*[@id='home']/div/div/div[@class='header__gms-wrapper']/a"));
		WebElement cross = driver.findElement(By.cssSelector(".offer__close"));
		ClickJS(cross);
	}

//		return closeSign;
		

	
	public void closepopup(){
		WebElement popup = null;

	try{
	  popup = waitForElementDisplayed(By.id("simplemodal-data"));
	  Assert.assertNotNull(popup);
	}
	catch(Exception ex)
	{
		//ex.printStackTrace();
	}
	
	if(popup != null){
		WebElement close = driver.findElement(By.cssSelector(".simplemodal-close"));
		highlightElement(close);
		close.click();
		delayFor(400);
	}
	}// end of popup
	
	
	public WebElement signin(){
		WebElement signIn= driver.findElement(By.xpath("html/body/div/header/div/div/ul/li[@id='util-account']/a"));
		highlightElement(signIn);
		return signIn;
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
	
	public WebElement waitForElementDisplayed(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
}
