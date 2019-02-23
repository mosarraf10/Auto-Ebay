package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String expectedURL = "https://www.ebay.com/signin/";

	public String getExpectedURL() {
		return expectedURL;
	}

	@FindBy(css = "#userid")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(css = "#pass")
	private WebElement passWord;

	public WebElement getPassWord() {
		return passWord;
	}

	@FindBy(css = "#sgnBt")
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

}
