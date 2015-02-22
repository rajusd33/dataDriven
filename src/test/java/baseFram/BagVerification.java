package baseFram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BagVerification extends ScriptBase {
	
	@Test
	public void CartTestTwoItem() throws Exception {
		//abercrombi().homepage().closepopup();
		abercrombi().shopping().menLink().click();;
		abercrombi().shopping().sweatersclick();
		abercrombi().shopping().firstSweater().click();
		abercrombi().shoppingbag().selectSize().click();
		abercrombi().shoppingbag().sizeM().click();
		abercrombi().shoppingbag().qntBoxInitial().click();
		delay();
		abercrombi().shoppingbag().qntChoose().click();
		delay();
		abercrombi().shoppingbag().addToBag().click();
		delay();
		abercrombi().shoppingbag().floatingCart();
		delay();
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		String bagprice = abercrombi().shoppingbag().priceInBag();
		Assert.assertEquals("$68.00", bagprice);
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().secondItem());
		abercrombi().shoppingbag().removeSecondItem().click();
		delay();
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		String bagPriceAfterRemoval = abercrombi().shoppingbag().priceInBag();
		Assert.assertEquals("$34.00", bagPriceAfterRemoval);
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().FirstItem());
		abercrombi().shoppingbag().removeFirstItem().click();
		delay();
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		String bagPriceAfterEmptying = abercrombi().shoppingbag().priceInEmptyBag();
		Assert.assertEquals("$0.00", bagPriceAfterEmptying);
	}
	
	
	@Test
	public void removeAllITemINBag() {
		//abercrombi().homepage().closepopup();
		abercrombi().homepage().signin().click();
		abercrombi().log().login("nasiha@gmail.com", "ABCD1234");
		//delay();
		abercrombi().log().submitButton().click();
		delay();
		abercrombi().shoppingbag().hoveronItem(abercrombi().shoppingbag().bag());
		abercrombi().shoppingbag().removeAllProductFromBag();
	}
	
	
	public void delay(){
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	
}// end of class