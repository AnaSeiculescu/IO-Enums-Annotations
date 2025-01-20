package org.example;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVContentParsingTest {

	CSVContentParsing contentParser = new CSVContentParsing();
	List<String> input = new ArrayList<>();
//	List<Athlete> biathlonAthletes = new ArrayList<>();

	@Test
	public void testCSVContentParsingSingleInput() {
		// prepare
		input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");

		//execute
		String expectedResult = "[Umar Jorgson 30:27]";
		List<Athlete> actualResult = contentParser.parsingTheFile(input, false);

		//verify
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	public void testCSVContentParsingNoInput() {
		// prepare

		//execute
		String expectedResult = "[]";
		List<Athlete> actualResult = contentParser.parsingTheFile(input, false);

		//verify
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	public void testCSVContentParsingTwoInput() {
		// prepare
		input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");

		//execute
		String expectedResult = "[Umar Jorgson 30:27, Jimmy Smiles 29:15]";
		List<Athlete> actualResult = contentParser.parsingTheFile(input, false);

		//verify
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	public void testCSVContentParsingWrongSingleInput() {
		// prepare
		input = List.of("11,Umar Jorgson,30:27,xxxox,xxxxx,xxoxo");

		//execute
		String expectedResult = null;
		List<Athlete> actualResult = contentParser.parsingTheFile(input, false);

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testCSVContentParsingWrongTwoInput() {
		// prepare
		input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,29:15,xxoox,xooxo,xxxxo");

		//execute
		String expectedResult = "[Umar Jorgson 30:27]";
		List<Athlete> actualResult = contentParser.parsingTheFile(input, false);

		//verify
		assertEquals(expectedResult, actualResult.toString());
	}

}