package org.example;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class StandingCalculationTest {

	@Test
	public void testStandingCalculationhappyPath() {
		// prepare
		List<String> input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo", "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx", "6, Paul Klein,DE,31:40,xoxxx,xxxox,oxxxx");
		StandingCalculation standingCalculation = new StandingCalculation(input);

		//execute
		List<Athlete> biathlonAthletes = standingCalculation.getBiathlonAthletes();
		List<Athlete> finalStandings = standingCalculation.getStandingCalculation(biathlonAthletes);

		String expectedResult = "[\nWinner - Piotr Smitzer 30:10 (30:10 + 0), \nRunner-up - Jimmy Smiles 29:15 (29:15 + 60), \nThird Place - Umar Jorgson 30:27 (30:27 + 30)]";
		String actualResult = standingCalculation.printFinalStandings(finalStandings);

		//verify
		assertEquals(expectedResult, actualResult);
	}

}