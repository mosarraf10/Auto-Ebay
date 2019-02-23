package testpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsReturned extends BasePage {

	public ItemsReturned(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a.s-item__link > h3.s-item__title")
	private List<WebElement> returnedItems;

	public List<WebElement> getReturnedItems() {
		return returnedItems;
	}

}
