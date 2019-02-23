package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class ValidateItemCatDdLvsFile extends BaseTest {

	@Test
	public void validateItemsCatDdvsList() throws FileNotFoundException {

		StoreFileInfoToList ifl = new StoreFileInfoToList();
		ItemCategoryDropDown icdd = new ItemCategoryDropDown();

		if (icdd.getItemCategoryDropDownList().equals(ifl.storeItemCatDdlFile())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (icdd.getItemCategoryDropDownList() == (ifl.storeItemCatDdlFile())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (icdd.getItemCategoryDropDownList() != (ifl.storeItemCatDdlFile())) {
			System.out.println("Lists DO NOT match! Verification FAILED!");
		}

	}
}
