package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVParsing {
	List<String> standings;

	Path path = Paths.get("src/main/resources/athletesResults.txt");

	private void readFile() {
		Path path = Paths.get("src/test/resources/fileTest.txt");

		try {
			List<String> standings = Files.readAllLines(path);
			System.out.println(standings);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}


}
