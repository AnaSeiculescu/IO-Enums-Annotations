package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StandingCalculationTest {

	@Test
	public void testStandingCalculationHappyPath() {
		// prepare
		List<String> input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo", "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx", "6, Paul Klein,DE,31:40,xoxxx,xxxox,oxxxx");
		StandingCalculation standingCalculation = new StandingCalculation(input);

		//execute
		List<Athlete> biathlonAthletes = standingCalculation.getBiathlonAthletes();
		List<Athlete> finalStandings = standingCalculation.getStandingCalculation(biathlonAthletes);
		String actualResult = standingCalculation.finalStandingsString(finalStandings);

		String expectedResult = "[\nWinner - Piotr Smitzer 30:10 (30:10 + 0), \nRunner-up - Jimmy Smiles 29:15 (29:15 + 60), \nThird Place - Umar Jorgson 30:27 (30:27 + 30)]";

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testStandingCalculationEmptyInput() {
		// prepare
		List<String> input = Arrays.asList();
		StandingCalculation standingCalculation = new StandingCalculation(input);

		//execute
		List<Athlete> biathlonAthletes = standingCalculation.getBiathlonAthletes();
		List<Athlete> finalStandings = standingCalculation.getStandingCalculation(biathlonAthletes);

		String expectedResult = "[]";
		String actualResult = standingCalculation.finalStandingsString(finalStandings);

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testStandingCalculationWrongInput() {
		// prepare
		List<String> input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");
		StandingCalculation standingCalculation = new StandingCalculation(input);

		//execute
		List<Athlete> biathlonAthletes = standingCalculation.getBiathlonAthletes();
		List<Athlete> finalStandings = standingCalculation.getStandingCalculation(biathlonAthletes);

		String expectedResult = "[]";
		String actualResult = standingCalculation.finalStandingsString(finalStandings);

		//verify
		assertEquals(expectedResult, actualResult);
	}
}