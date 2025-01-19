package org.example;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The type Csv reading.
 * readFile private method - reads the file from the specified path, and puts the content in a List (of strings)
 * getBiathlonResults method - reads the file if the list of strings is empty, returns the list of strings
 */
@Getter
public class CSVReading {
	private List<String> biathlonResults;
	private final Path path;

//	Path path = Paths.get("src/main/resources/athletesResults.csv");
	public CSVReading(Path path) {
		this.path = path;
	}

	private void readFile() {

		try {
			biathlonResults = Files.readAllLines(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<String> getBiathlonResults() {
		if (biathlonResults == null) {
			readFile();
		}
		return biathlonResults;
	}

}
