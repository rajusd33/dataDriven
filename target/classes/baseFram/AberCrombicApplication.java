package baseFram;

import org.openqa.selenium.WebDriver;

import pages.CheckoutPG;
import pages.ShoppingBag;
import pages.Homepage;
import pages.Log;
import pages.Shopping;

public class AberCrombicApplication {
	
	
	protected WebDriver driver;
	private Homepage homepage;
	private Log log;
	private Util util;
	private MyDataReader dataReader;
	private String filepath = "C:/Users/PaxoTech Student/Desktop/info.xlsx";
	private Shopping shopping;
	private ShoppingBag shoppingbag;
	private CheckoutPG checkoutPg;

	
	
	AberCrombicApplication(WebDriver driver){
		this.driver=driver;
	}
	
	public Homepage homepage(){
		if (homepage==null){
			homepage= new Homepage(driver);
		}
		return homepage;
	}
	public Log log(){
		if (log==null){
			log= new Log(driver);
		}
		
		return log;
	}
	
	public Util util(){
		if (util==null){
			util= new Util(driver);
		}
		
		return util;
	}
	public MyDataReader dataReader() throws Exception{
		if (dataReader==null){
			dataReader= new MyDataReader();
		}
		
		return dataReader;
	}

	public Shopping shopping(){
		if (shopping==null){
			shopping= new Shopping(driver);
		}
		
		return shopping;
	}

	public ShoppingBag shoppingbag(){
		if (shoppingbag==null){
			shoppingbag= new ShoppingBag(driver);
		}
		
		return shoppingbag;
	}
	
	public CheckoutPG checkoutPg(){
		if (checkoutPg==null){
			checkoutPg= new CheckoutPG(driver);
		}
		return checkoutPg;
	}

	
}// end of class
