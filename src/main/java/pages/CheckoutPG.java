package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPG {
	WebDriver driver;
	
	public CheckoutPG(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement firstNameTBox(){
		WebElement box = driver.findElement(By.xpath(".//input[@id='first-name-field']"));
		highlightElement(box);
		return box;
	}
	
	
	public WebElement lastNameTBox(){
		WebElement box = driver.findElement(By.xpath("//input[@id='last-name-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement addressOneTBox(){
		WebElement box = driver.findElement(By.xpath("//input[@id='address-field']"));
		highlightElement(box);
		return box;
	}
	public WebElement address2TBox(){
		WebElement box = driver.findElement(By.xpath("//input[@id='address-2-field']"));
		highlightElement(box);
		return box;
	}

	public WebElement city(){
		WebElement box = driver.findElement(By.xpath("//input[@id='city-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement zip(){
		WebElement box = driver.findElement(By.xpath("//input[@id='zip-code-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement paymentButton(){
		WebElement button = driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div[1]/div/div/form/div[2]/div/a"));
		highlightElement(button);
		return button;
	}
	
	public void processshippingOption(String FName, String LName, String Add1, String Add2, String City, String Zip){
		firstNameTBox().sendKeys(FName);
		lastNameTBox().sendKeys(LName);
		addressOneTBox().sendKeys(Add1);
		address2TBox().sendKeys(Add2);
		city().sendKeys(City);
		zip().sendKeys(Zip);	
		paymentButton().click();
		}// end of shippingOption
	
	
	public void addressCorrection(){
		delayFor(400);
		WebElement AddresstoCorrect = driver.findElement(By.xpath("html/body/div[16]/div/div/ul[2]/li[2]"));
		AddresstoCorrect.click();
	}
	
	public WebElement cardNumberBox(){
		WebElement box = driver.findElement(By.xpath("//input[@id='card-number-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardSelectBox(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-brand-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardChoose(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-brand-field']/option[@data-paymentcode='001']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardExpMonthBox(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-exp-month']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardExpSelectMonth(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-exp-month']/option[@value='01']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardExpYearbox(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-exp-year']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement cardExpSelectYear(){
		WebElement box = driver.findElement(By.xpath("//select[@id='card-exp-year']/option[@value='2015']"));
		highlightElement(box);
		return box;
	}
	public WebElement cSSVCode(){
		WebElement box = driver.findElement(By.xpath("//input[@id='csv-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement phone(){
		WebElement box = driver.findElement(By.xpath("//input[@id='pay-phone-field']"));
		return box;
	}
	
	
	public WebElement email(){
		WebElement box = driver.findElement(By.xpath("//input[@id='pay-email-field']"));
		highlightElement(box);
		return box;
	}
	
	public WebElement placeOrder(){
		WebElement box = driver.findElement(By.xpath("//a[@id='checkoutLink']/span"));
		highlightElement(box);
		return box;
	}
	
	public void processPayment(String number, String CSVV, String phone, String email){
		delayFor(400);
		cardNumberBox().sendKeys(number);
		cardSelectBox().click();
		cardChoose().click();
		cardExpMonthBox().click();
		cardExpSelectMonth().click();
		cardExpYearbox().click();
		cardExpSelectYear().click();
		cSSVCode().sendKeys(CSVV);
		phone().sendKeys(phone);
		email().sendKeys(email);
		placeOrder().click();
	}
	
	public WebElement correctHighlightedFiledMSG(){
		WebElement correctMSG = driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div[1]/div[4]/div[2]/form/div[4]/ul/li"));
		highlightElement(correctMSG);
		return correctMSG;
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

}	// end of class
