package baseFram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutNG extends ScriptBase {

	@Test
	public void checkoutNGTest() throws Exception {
		//abercrombi().homepage().closepopup();
		abercrombi().shopping().menLink().click();
		abercrombi().shopping().sweatersclick();
		abercrombi().shopping().firstSweater().click();
		abercrombi().shoppingbag().selectSize().click();
		abercrombi().shoppingbag().sizeM().click();
		abercrombi().shoppingbag().qntBoxInitial().click();
		abercrombi().util().delayFourSec();
		abercrombi().shoppingbag().qntChoose().click();
		abercrombi().util().delayFourSec();
		abercrombi().shoppingbag().addToBag().click();
		abercrombi().util().delayFourSec();
		abercrombi().shoppingbag().floatingCart();
		abercrombi().util().delayFourSec();
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		String bagprice = abercrombi().shoppingbag().priceInBag();
		Assert.assertEquals("$68.00", bagprice);
		abercrombi().shoppingbag().CheckbuttonInBag().click(); //
		abercrombi().util().delayFourSec();
		abercrombi().checkoutPg().processshippingOption("Anjal", "Hussan", "3230 Steinway Street", "Apt: #R", "Astoria", "11103");
		//abercrombi().checkoutPg().addressCorrection(); // to accept the address as inserted
		abercrombi().util().delayFourSec();
		abercrombi().checkoutPg().processPayment("1234567898123456", "123", "4560908877", "test@yahoo.com");
		String correctionMSG = abercrombi().checkoutPg().correctHighlightedFiledMSG().getText();
		
		Assert.assertEquals(correctionMSG, "PLEASE CORRECT THE HIGHLIGHTED FIELDS.");
		
	}
	
}// end of class
