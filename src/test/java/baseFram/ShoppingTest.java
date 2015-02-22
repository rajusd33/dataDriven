package baseFram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends ScriptBase {
	
	@Test
	public void CheckoutTotalVerifiy(){
	  //abercrombi().homepage().closepopup();
	  abercrombi().shopping().menLink().click();
	  abercrombi().util().delayFor2(2000);
	  abercrombi().shopping().shirtInMenu().click();
	  String actualprice = abercrombi().shopping().priceOfFirstShirt();
	  actualprice = actualprice+".00";
	  abercrombi().shopping().firstShirt().click();
	  abercrombi().shopping().selectSize().click();
	  abercrombi().shopping().sizesmall().click();
	  abercrombi().shopping().addToBag().click();
	  abercrombi().util().delayFor2(2000);
	  abercrombi().shoppingbag().floatingCart();
	  abercrombi().util().delayFor2(2000);
	  abercrombi().shopping().checkout().click();
	  String priceInCart = abercrombi().shopping().orderTotalinCart();
	  //actualprice = actualprice + ".00"; // to match with cart price format
	  Assert.assertEquals(actualprice, priceInCart);
	} // end of shopping test

} // end of class
