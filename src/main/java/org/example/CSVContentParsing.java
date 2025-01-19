package org.example;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVContentParsing {
	List<Athlete> biathlonAthletes = new ArrayList<>();

//	CSVReading csvContent = new CSVReading(Paths.get("src/main/resources/athletesResults.csv"));
//	List<String> results = csvContent.getBiathlonResults();

	public void parsingTheFile(List<String> fileEntries, boolean hasHeaderRow) {

		for (int i = hasHeaderRow ? 1 : 0; i < fileEntries.size(); i++) {
			String currentEntry = fileEntries.get(i);
			String[] pieces = currentEntry.split(",");

			String[] time = pieces[3].split(":");
			TimeResult timeResult = new TimeResult(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

			pieces[4] = pieces[4] + pieces[5] + pieces[6];

			Athlete athlete = new Athlete(Integer.parseInt(pieces[0]), pieces[1], CountryCode.valueOf(pieces[2]), timeResult, pieces[4]);

			biathlonAthletes.add(athlete);
			Collections.sort(biathlonAthletes, new AthletesTimeComparator());
		}

	}

}
