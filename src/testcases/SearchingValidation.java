package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testpages.Header;
import testpages.ItemsReturned;

public class SearchingValidation extends BaseTest {

	Header head = new Header(driver);
	ItemsReturned it = new ItemsReturned(driver);

	@Test
	@Parameters({ "item" })
	public void validateSearchFunctionality(String item) {
		head.getSearchBox().sendKeys(item);
		head.getSearchButton().click();

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

}
