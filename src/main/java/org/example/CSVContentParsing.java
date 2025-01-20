package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVContentParsing {
	List<Athlete> biathlonAthletes = new ArrayList<>();

	public void parsingTheFile(List<String> fileEntries, boolean hasHeaderRow) {

		for (int i = hasHeaderRow ? 1 : 0; i < fileEntries.size(); i++) {
			String currentEntry = fileEntries.get(i);
			String[] pieces = currentEntry.split(",");

			String[] time = pieces[3].split(":");
			TimeResult timeResult = new TimeResult(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

			int competitionNumber = Integer.parseInt(pieces[0]);
			String name = pieces[1];
			CountryCode countryCode = CountryCode.valueOf(pieces[2]);
			String shootingResult = pieces[4] + pieces[5] + pieces[6];

			Athlete athlete = new Athlete(competitionNumber, name, countryCode, timeResult, shootingResult);

			biathlonAthletes.add(athlete);
			Collections.sort(biathlonAthletes, new AthletesTimeComparator());
		}

	}

}
