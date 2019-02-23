package testcases;

import org.testng.annotations.Test;

public class ValidateItemsDropDown extends BaseTest {

	@Test
	public void validateItemsCatDdvsList() {

		ItemCatDdList idl = new ItemCatDdList();
		ItemCategoryDropDown icdd = new ItemCategoryDropDown();

		if (icdd.getItemCategoryDropDownList().equals(idl.createItemCatDdList())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (icdd.getItemCategoryDropDownList() == (idl.createItemCatDdList())) {
			System.out.println("Lists match. Dropdown Verification PASSED!");
		} else if (icdd.getItemCategoryDropDownList() != (idl.createItemCatDdList())) {
			System.out.println("Lists DO NOT match! Verification FAILED!");
		}

	}
}
