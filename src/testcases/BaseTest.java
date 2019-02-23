package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import testpages.LoginPage;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void getSetup() {

		String os = System.getProperty("os.name").toLowerCase();

		String path = System.getProperty("user.dir");
		String winDriverPath = path + "\\Drivers\\chromedriver.exe";

		String macDriverPath = path + "/Drivers/chromedriver";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}

		driver = new ChromeDriver();
	}

	@BeforeMethod
	@Parameters({ "userName", "passWord" })
	public void getBrowser(String userName, String passWord) {

		LoginPage lp = new LoginPage(driver);

		driver.navigate().to(lp.getExpectedURL());
		String actualURL = driver.getCurrentUrl();
		try {
			Assert.assertEquals(lp.getExpectedURL(), actualURL);
			System.out.println("Actual URL matches expected URL. Validation PASSED!");
		} catch (Exception e) {
			System.out.println("Actual URL does NOT match expected URL. Validation FAILED!");
		}

		lp.getUserName().sendKeys(userName);
		lp.getPassWord().sendKeys(passWord);
		lp.getSignInButton().click();

	}

	@AfterMethod
	public void segregateTests() {
		System.out.println("Test Cases have run");
	}

}
