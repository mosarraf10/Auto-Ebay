package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage{

	public ShoppingCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//*[contains(text(),'Shopping cart')])[2]")
	private WebElement shoppingCartPageText;
	
	public WebElement getShoppingCartPageText() {
		return shoppingCartPageText;
	}

}
