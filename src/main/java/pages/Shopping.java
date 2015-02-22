package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Shopping {

	WebDriver driver;
	public Shopping(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement menLink(){
		delayFor(50);
		WebElement menLink = driver.findElement(By.xpath(".//*[@id='division_12202']"));
		//WebElement menLink = waitForElementDisplayed(By.id("cat-12202"));
		highlightElement(menLink);
		return menLink;
	}
	
	public WebElement shirtInMenu(){
		delayFor(40);
		WebElement shirt; /*= driver.findElement(By.xpath("html/body//div/ul/li[@id='cat-87658-anf']/a"));*/
		shirt = waitForElementDisplayed(By.xpath("html/body//div/ul/li[@id='cat-87658-anf']/a"));
		highlightElement(shirt);
		return shirt;
	}
	
	public WebElement firstShirt(){
		delayFor(50);
		WebElement firstshirt = driver.findElement(By.xpath("//div[@id='pid-2941108']/div/div/h2/a"));
		highlightElement(firstshirt);
		return firstshirt;
	}
	
	public String priceOfFirstShirt(){
		delayFor(50);
		WebElement priceofFirstShirt = driver.findElement(By.xpath("//div[@id='pid-2941108']/div/div/span[@class='offer-price']"));
		highlightElement(priceofFirstShirt);
		String priceOfFirstShirt = priceofFirstShirt.getText();
		return priceOfFirstShirt;
	}
	
	public WebElement addToBag(){
		delayFor(50);
		WebElement addToBag = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div/div/form/div[@class='actions']/ul/li/a"));
		highlightElement(addToBag);
		return addToBag;
	}
	
	public WebElement selectSize(){
		delayFor(50);
		WebElement selectSize = driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[1]/div[1]/div[3]/form/div[1]/ul/li[1]/div/a/span"));
		highlightElement(selectSize);
		return selectSize;
	}
	
	public WebElement sizesmall(){
		delayFor(50);
		WebElement sizesmall = driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[1]/div[1]/div[3]/form/div[1]/ul/li[1]/div/div/ul/li[2]/a"));
		highlightElement(sizesmall);
		return sizesmall;
	}
	
	public WebElement checkout(){
		delayFor(50);
		WebElement checkout = driver.findElement(By.xpath("//body/header/div/div/ul/li[@id='util-checkout']/a/span"));
		highlightElement(checkout);
		return checkout;
	}
	
	public String orderTotalinCart(){
		delayFor(50);
		WebElement ordertotal = driver.findElement(By.xpath(".//div[@id='item-total']"));
		highlightElement(ordertotal);
		String orderTotal = ordertotal.getText();
		return orderTotal;
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
	
	public void sweatersclick(){
		delayFor(50);
		WebElement sweater = driver.findElement(By.xpath(".//*[@id='cat-12206-anf']/a"));
		highlightElement(sweater);
		sweater.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement firstSweater(){
		WebElement firstSw = driver.findElement(By.xpath(".//*[@id='pid-3825589']/div[2]/div[1]/h2/a"));
		highlightElement(firstSw);
		return firstSw;
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
}// end of class
