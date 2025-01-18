package org.example;

import java.nio.file.Paths;
import java.util.List;

public class CSVContentParsing {
	List<Athlete> biathlonAthletes;

//	CSVReading csvContent = new CSVReading(Paths.get("src/main/resources/athletesResults.csv"));
//	List<String> results = csvContent.getBiathlonResults();

	public void fileParsing(List<String> fileEntries, boolean hasHeaderRow) {

		for (int i = hasHeaderRow ? 1 : 0; i < fileEntries.size(); i++) {
			String currentEntry = fileEntries.get(i);
			String[] pieces = currentEntry.split(",");
			Athlete athlete = new Athlete(Integer.parseInt(pieces[0]), pieces[1], CountryCode.valueOf(pieces[2]), pieces[3], pieces[4], pieces[5], pieces[6]);

			biathlonAthletes.add(athlete);
		}

	}

}
