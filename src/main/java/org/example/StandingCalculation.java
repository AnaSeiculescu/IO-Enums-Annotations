package org.example;

import lombok.Getter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class StandingCalculation {
	private final List<Athlete> finalStandings = new ArrayList<>();
	private CSVReading csvContent;
	private List<String> results;
	private CSVContentParsing csvContentParsing;
	private List<Athlete> biathlonAthletes;

	public StandingCalculation(List<String> results) {
		this.csvContentParsing = new CSVContentParsing();
		this.biathlonAthletes = csvContentParsing.parseFileContent(results, false);
	}

	public StandingCalculation() {
		this.csvContent = new CSVReading(Paths.get("src/main/resources/athletesResults.csv"));
		this.results = csvContent.getBiathlonResults();

		this.csvContentParsing = new CSVContentParsing();
		this.biathlonAthletes = csvContentParsing.parseFileContent(results, true);
	}

	/**
	 * Calculation of the final standings.
	 * Creates instances for reading the file, and for parsing the file.
	 * Parses the file and stores the athletes instances in a list.
	 * The list of Athletes is sorted after the updated time (method in Athlete class).
	 * From all the athletes, takes the first three in the finalStandings ArrayList.
	 * @return the list of the final 3 standings
	 */
	public List<Athlete> getStandingCalculation(List<Athlete> biathlonAthletes) {
		try {
			if (biathlonAthletes == null) {
				throw new NullPointerException("The provided list is null.");
			}
			if (biathlonAthletes.isEmpty()) {
				throw new IllegalArgumentException("The provided list is empty.");
			}
			if (biathlonAthletes.size() < 3) {
				throw new IllegalArgumentException("The list must contain at least 3 athletes.");
			}

			Collections.sort(biathlonAthletes, new AthletesTimeComparator());

		} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		return getFirstThree(biathlonAthletes);
	}

	private List<Athlete> getFirstThree(List<Athlete> biathlonAthletes) {
		for (int i = 0; i < 3; i++) {
			Athlete current = biathlonAthletes.get(i);
			finalStandings.add(current);
		}
		return finalStandings;
	}

	public int addSecondsToInitialTime(Athlete athlete) {
		return athlete.getMissedShots() * 10;
	}

	public String finalStandingsString(List<Athlete> finalStandings) {
		Positions[] position = Positions.values();
		List<String> finalStandingsToPrint = new ArrayList<>();

		for (int i = 0; i < finalStandings.size(); i++) {
			finalStandingsToPrint.add(
					"\n" + position[i] + " - " + finalStandings.get(i) +
							" (" + finalStandings.get(i).getSkiTimeResult() + " + " +
							addSecondsToInitialTime(finalStandings.get(i)) + ")"
			);
		}
		return finalStandingsToPrint.toString();
	}

	@Override
	public String toString() {
		return finalStandingsString(finalStandings);
	}
}
