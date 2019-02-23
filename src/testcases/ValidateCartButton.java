package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testpages.Header;
import testpages.ShoppingCart;

public class ValidateCartButton extends BaseTest {

	Header head = new Header(driver);
	ShoppingCart cart = new ShoppingCart(driver);

	@Test
	public void validateCartButton() {

		if (head.getCartButton().isDisplayed() && head.getCartButton().isEnabled()) {
			System.out.println("Cart Button is displayed and is enabled. VERIFICATION PASSED!");
			head.getCartButton().click();
		} else {
			System.out.println("Cart Button is NOT displayed is NOT enabled. VERIFICATION FAILED!");
		}
		try {
			Assert.assertEquals(cart.getShoppingCartPageText().getText(), "Shopping cart");
			System.out.println("Header in Cart page match expected. Validation PASSED!");
		} catch (Exception e) {
			System.out.println("Heading in Cart page do not match expected. Validation FAILED!");
		}

	}
}
