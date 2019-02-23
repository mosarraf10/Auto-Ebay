package javaframework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTestCases {

	public static void main(String[] args) {

		String os = System.getProperty("os.name").toLowerCase();

		String path = System.getProperty("user.dir");
		String winDriverPath = path + "\\Drivers\\chromedriver.exe";

		String macDriverPath = path + "/Drivers/chromedriver";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}

		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.ebay.com/");

		List<WebElement> itemsCatDD = driver.findElements(By.cssSelector("#gh-cat"));
		List<String> stringItemsCatDD = new ArrayList<String>();
		for (WebElement w : itemsCatDD) {
			stringItemsCatDD.add(w.getText());
		}
		for (String s : stringItemsCatDD) {
			System.out.println(s);
		}

	}

}
