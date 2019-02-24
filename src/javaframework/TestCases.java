package javaframework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import testcases.ItemCatDdList;
import testcases.ItemCategoryDropDown;
import testcases.StoreFileInfoToList;
import testpages.Header;
import testpages.ItemsReturned;
import testpages.LoginPage;
import testpages.ShoppingCart;

public class TestCases {

	WebDriver driver = new ChromeDriver();

	Header header = new Header(driver);
	ShoppingCart cart = new ShoppingCart(driver);
	ItemsReturned it = new ItemsReturned(driver);
	LoginPage lp = new LoginPage(driver);

	public void setUp() {

		String os = System.getProperty("os.name").toLowerCase();

		String path = System.getProperty("user.dir");
		String winDriverPath = path + "\\Drivers\\chromedriver.exe";

		String macDriverPath = path + "/Drivers/chromedriver";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}

	}

	public void getBrowser(String userName, String passWord) {

		driver.navigate().to(lp.getExpectedURL());
		String actualURL = driver.getCurrentUrl();
		try {
			Assert.assertEquals(lp.getExpectedURL(), actualURL);
			System.out.println("Actual URL matcheaders expected URL. Validation PASSED!");
		} catch (Exception e) {
			System.out.println("Actual URL does NOT match expected URL. Validation FAILED!");
		}

		lp.getUserName().sendKeys(userName);
		lp.getPassWord().sendKeys(passWord);
		lp.getSignInButton().click();

	}

	public void validateSearchBox() {

		if (header.getSearchBox().isDisplayed() && header.getSearchBox().isEnabled()) {
			System.out.println("Search box is displayed and is enabled. VERIFICATION PASSED!");
		} else {
			System.out.println("Search box is NOT displayed is NOT enabled. VERIFICATION FAILED!");
		}
	}

	public void validateSearchButton() {

		if (header.getSearchButton().isDisplayed() && header.getSearchButton().isEnabled()) {
			System.out.println("Search Button is displayed and is enabled. VERIFICATION PASSED!");
		} else {
			System.out.println("Search Button is NOT displayed is NOT enabled. VERIFICATION FAILED!");
		}

	}

	public void validateCartButton() {

		if (header.getCartButton().isDisplayed() && header.getCartButton().isEnabled()) {
			System.out.println("Cart Button is displayed and is enabled. VERIFICATION PASSED!");
			header.getCartButton().click();
		} else {
			System.out.println("Cart Button is NOT displayed is NOT enabled. VERIFICATION FAILED!");
		}
		try {
			Assert.assertEquals(cart.getShoppingCartPageText().getText(), "Shopping cart");
			System.out.println("headerader in Cart page match expected. Validation PASSED!");
		} catch (Exception e) {
			System.out.println("headerading in Cart page do not match expected. Validation FAILED!");
		}

	}

	public void validateSearchFunctionality(String item) {
		header.getSearchBox().sendKeys(item);
		header.getSearchButton().click();

		List<WebElement> returnedItems = it.getReturnedItems();
		List<String> resultOfsearchedItems = new ArrayList<String>();

		for (WebElement w : returnedItems) {
			resultOfsearchedItems.add(w.getText());
		}

		for (int i = 0; i < resultOfsearchedItems.size(); i++) {
			if (resultOfsearchedItems.get(i).contains("iPhone")) {
				System.out.println("Search result returned iPhone. Verification PASSED!");
			} else {
				System.out.println("Search result did NOT return iPhone. Verification FAILED!");
			}
		}
	}

	public List<String> getItemCategoryDropDownList() {

		List<WebElement> itemCatDdL = header.getItemCategories();
		List<String> stringItemCatDdl = new ArrayList<String>();

		for (WebElement w : itemCatDdL) {
			stringItemCatDdl.add(w.getText());
		}
		return stringItemCatDdl;
	}

	public List<String> createItemCatDdList() {

		List<String> itemCatDdStringList = new ArrayList<String>();
		itemCatDdStringList.addAll(Arrays.asList("All Categories", "Antiques", "Art", "Baby", "Books",
				"Business & Industrial", "Cameras & Photo", "Cell Phones & Accessories",
				"Clothing, Shoes & Accessories", "Coins & Paper Money", "Collectibles",
				"Computers/Tablets & Networking", "Consumer Electronics", "Crafts", "Dolls & Bears", "DVDs & Movies",
				"eBay Motors", "Entertainment Memorabilia", "Gift Cards & Coupons", "Health & Beauty", "Home & Garden",
				"Jewelry & Watches", "Music", "Musical Instruments & Gear", "Pet Supplies", "Pottery & Glass",
				"Real Estate", "Specialty Services", "Sporting Goods", "Sports Mem, Cards & Fan Shop", "Stamps",
				"Tickets & Experiences", "Toys & Hobbies", "Travel", "Video Games & Consoles", "Everything Else"));

		return itemCatDdStringList;

	}

	public void validateItemsCatDdvsList() {

		if (this.getItemCategoryDropDownList().equals(this.createItemCatDdList())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (this.getItemCategoryDropDownList() == (this.createItemCatDdList())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (this.getItemCategoryDropDownList() != (this.createItemCatDdList())) {
			System.out.println("Lists DO NOT match! Verification FAILED!");
		}

	}

	public List<String> storeItemCatDdlFile() throws FileNotFoundException {

		List<String> itemCatDdlFile = new ArrayList<String>();

		String userDir = System.getProperty("user.dir");

		String filePath = userDir + "/Files/itemCatDd.txt";

		try (Scanner s = new Scanner(new FileReader(filePath))) {
			while (s.hasNext()) {
				itemCatDdlFile.add(s.nextLine());
			}
			return itemCatDdlFile;

		}
	}

	public void validateItemsCatDdvsFile() throws FileNotFoundException {

		if (this.getItemCategoryDropDownList().equals(this.storeItemCatDdlFile())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (this.getItemCategoryDropDownList() == (this.storeItemCatDdlFile())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (this.getItemCategoryDropDownList() != (this.storeItemCatDdlFile())) {
			System.out.println("Lists DO NOT match! Verification FAILED!");
		}

	}

	public void endTest() {
		driver.close();
		driver.quit();
	}
}
