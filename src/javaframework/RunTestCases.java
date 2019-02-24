package javaframework;

import java.io.FileNotFoundException;

public class RunTestCases {

	public static void main(String[] args) throws FileNotFoundException {

		TestCases cases = new TestCases();

		cases.setUp();
		cases.getBrowser("shiblee_1986@outlook.com", "123$abcZY");
		cases.validateSearchBox();
		cases.validateSearchButton();
		cases.validateCartButton();
		cases.validateSearchFunctionality("iPhone");
		cases.getItemCategoryDropDownList();
		cases.validateItemsCatDdvsList();
		cases.validateItemsCatDdvsFile();
		cases.endTest();
	}

}
