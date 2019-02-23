package testpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage{

	public Header(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#gh-ac")
	private WebElement searchBox;

	public WebElement getSearchBox() {
		return searchBox;
	}

	@FindBy(css = "#gh-btn")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy(css = "#gh-cart-i")
	private WebElement cartButton;

	public WebElement getCartButton() {
		return cartButton;
	}

	@FindBy(css = "#gh-cat")
	private List<WebElement> itemCategories;

	public List<WebElement> getItemCategories() {
		return itemCategories;
	}

	@FindBy(xpath = "//h2[contains(text(),'Buy It Now')]")
	private WebElement buyItNowButton;

	public WebElement getBuyItNowButton() {
		return buyItNowButton;
	}

	@FindBy(css = "#w9-w5-w0-follow-faux-btn")
	private WebElement saveThisSearch;

	public WebElement getSaveThisSearch() {
		return saveThisSearch;
	}

}
