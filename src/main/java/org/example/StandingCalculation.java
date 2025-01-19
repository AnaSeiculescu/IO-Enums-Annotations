package org.example;

import lombok.Getter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StandingCalculation {
	private final List<Athlete> finalStandings = new ArrayList<>();

	public void calculationOfTheStandings() {
		CSVReading csvContent = new CSVReading(Paths.get("src/main/resources/athletesResults.csv"));
		List<String> results = csvContent.getBiathlonResults();

		CSVContentParsing csvContentParsing = new CSVContentParsing();
		csvContentParsing.parsingTheFile(results,true);

		List<Athlete> biathlonAthletes = csvContentParsing.biathlonAthletes;

		for (int i = 0; i < 3; i++) {
			Athlete current = biathlonAthletes.get(i);
			finalStandings.add(current);
		}
	}

	@Override
	public String toString() {
		String[] position = {"Winner", "Runner-up", "Third-place"};
		List<String> finalStandingsToPrint = new ArrayList<>();

		for (int i = 0; i < finalStandings.size(); i++) {
			finalStandingsToPrint.add("\n" + position[i] + finalStandings.get(i) + " " + finalStandings.get(i).updateTimeWithPenalties());
		}
		return finalStandingsToPrint.toString();
	}
}
