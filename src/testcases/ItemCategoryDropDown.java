package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testpages.Header;

public class ItemCategoryDropDown extends BaseTest {

	Header h = new Header(driver);

	@Test
	public List<String> getItemCategoryDropDownList() {

		List<WebElement> itemCatDdL = h.getItemCategories();
		List<String> stringItemCatDdl = new ArrayList<String>();

		for (WebElement w : itemCatDdL) {
			stringItemCatDdl.add(w.getText());
		}
		return stringItemCatDdl;
	}

}
