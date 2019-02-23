package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[contains(text(),'My eBay:')]")
	private WebElement myAccountText;

	public WebElement getMyAccountPage() {
		return myAccountText;
	}
}
