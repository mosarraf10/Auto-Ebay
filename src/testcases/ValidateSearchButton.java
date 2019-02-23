package testcases;

import org.testng.annotations.Test;

import testpages.Header;

public class ValidateSearchButton extends BaseTest {

	public class ValidateSearchBox extends BaseTest {

		Header obj = new Header(driver);

		@Test
		public void validateSearchButton() {

			if (obj.getSearchButton().isDisplayed() && obj.getSearchButton().isEnabled()) {
				System.out.println("Search Button is displayed and is enabled. VERIFICATION PASSED!");
			} else {
				System.out.println("Search Button is NOT displayed is NOT enabled. VERIFICATION FAILED!");
			}

		}

	}

}
