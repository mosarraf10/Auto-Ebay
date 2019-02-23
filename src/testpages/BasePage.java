package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;

	public void getInit() {
		PageFactory.initElements(driver, this);
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		getInit();
	}

}
