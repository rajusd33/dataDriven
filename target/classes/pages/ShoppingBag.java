package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.base.Function;

public class ShoppingBag {
	
	WebDriver driver;

	public ShoppingBag(WebDriver driver) {
		this.driver=driver;
	}

	
	public WebElement selectSize (){
		WebElement size = driver.findElement(By.xpath(".//*[@id='dk_container_partNumber-89622']/a/span"));
		return size;
	}

	public WebElement sizeM(){
		WebElement sizeM = driver.findElement(By.xpath(".//*[@id='dk_container_partNumber-89622']/div/ul/li[3]/a"));
		return sizeM;
	}
	
	public WebElement addToBag(){
		WebElement button = driver.findElement(By.xpath(".//*[@id='product-add-to-bag-89622']/form/div[2]/ul/li/a"));
		return button;
	}
	
	public WebElement qntBoxInitial(){
		WebElement qntBox  = driver.findElement(By.xpath(".//*[@id='dk_container_quantity-89622']/a/span"));
		return qntBox;

	}
	
	public WebElement qntChoose(){
		WebElement qntTwo = driver.findElement(By.xpath(".//*[@id='dk_container_quantity-89622']/div/ul/li[2]/a"));
		return qntTwo;
	}
	
	public WebElement bag(){
		WebElement bag = driver.findElement(By.xpath(".//*[@id='util-minicart']/a/span[1]"));
		return bag;
	}
	
	public void hoveronItem(WebElement Element){
		Actions builder = new Actions(driver); 
		Actions hoverOverRegistrar = builder.moveToElement(Element);
		hoverOverRegistrar.perform();
	}
	
	public String priceInBag(){
		WebElement price = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[1]/div[2]/p/span/span"));
		String bagprice = price.getText();
		return bagprice;
	}
	
	public String priceInEmptyBag(){
		WebElement price = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[1]/div/p/span/span"));
		String bagprice = price.getText();
		return bagprice;
	}
	
	public WebElement secondItem(){
		WebElement item = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[2]/ul/li[2]"));
		return item;
	}
	
	public WebElement removeSecondItem(){
		WebElement remove = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[2]/ul/li[2]/ul[2]/li[2]/a"));
		return remove;
	}
	
	public WebElement removeFirstItem(){
		WebElement remove = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[2]/ul/li/ul[2]/li[2]/a"));
		return remove;
	}
	
	public WebElement FirstItem(){
		WebElement item = driver.findElement(By.xpath(".//*[@id='minicart-contents']/div[2]/ul/li"));
		return item;
	}
	
	public WebElement CheckbuttonInBag (){
		WebElement button = driver.findElement(By.xpath("//a[@id='mini-cart-checkout']"));
		return button;
	}
	
	
	
	public void removeAllProductFromBag (){
		try{
		WebElement firstItem = FirstItem();
		if(firstItem!=null){
			do{
			delayFor(1000);
			hoveronItem(firstItem);
			delayFor(1000);
			removeFirstItem().click();
			delayFor(1000);
			hoveronItem(bag());
				}while(firstItem!= null);
			}
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
		}
	}
	
	
	
	public void floatingCart(){
		WebElement popup = null;
		try{
		  popup = waitForElementDisplayed(By.id("simplemodal-container"));
		  Assert.assertNotNull(popup);
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
		}
		if(popup != null){
			WebElement close = driver.findElement(By.xpath("//div[@id='simplemodal-container']/a"));
			highlightElement(close);
			close.click();
			delayFor(400);
		}
	}// end of floatingcart
	

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
	
} // end of class
