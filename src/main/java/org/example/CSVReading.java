package org.example;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Csv reading.
 * @method readFile - reads the file from the specified path, and puts the content in a List (of strings)
 * @method getBiathlonResults - reads the file (only if the list of strings is empty), returns the list of strings
 */
@Getter
public class CSVReading {

	private List<String> biathlonResults = new ArrayList<>();
	private final Path path;

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

	/**
	 * Gets biathlon results.
	 * reads the file (only if the list of strings is empty), returns the list of strings
	 *
	 * @return the biathlon results
	 */
	public List<String> getBiathlonResults() {
		if (biathlonResults.isEmpty()) {
			readFile();
		}
		return biathlonResults;
	}

}
