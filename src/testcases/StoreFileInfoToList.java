package testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreFileInfoToList {

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
	
}
