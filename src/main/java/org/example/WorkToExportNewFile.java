package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
public class WorkToExportNewFile {
	StandingCalculation standingCalculation = new StandingCalculation();
	List<Athlete> fullListOfAthletes = standingCalculation.getBiathlonAthletes();
	List<Athlete> finalStandings = standingCalculation.getStandingCalculation(fullListOfAthletes);

	public void createJsonObjectAndFile() {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			objectMapper.writeValue(new File("exportJsonFile.json"),finalStandings);
		} catch (IOException e) {
			System.out.println("An error occurred while writing the JSON file: " + e.getMessage());
		}

	}

}
