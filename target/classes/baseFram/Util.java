package baseFram;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
	
	WebDriver driver;
	
	public Util(WebDriver driver){
		this.driver= driver;
	}
	
	public void hoverOnHEY(WebElement element){
	Actions action = new Actions(driver);
	action.moveToElement(element);
	action.perform();
	delayFor(20);
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


	public void delayFourSec(){
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
	
	public void delayFor2(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void clickEx(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				element);
	}

protected void ClickJS(WebElement element){
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
}

}// END OF CLASS