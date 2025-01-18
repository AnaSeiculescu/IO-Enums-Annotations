package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Athlete {
	private int number;
	private String name;
	private CountryCode country;
	private String skiTimeResult;
	private String firstShooting;
	private String secondShooting;
	private String thirdShooting;

	public Athlete(String name) {
		this.name = name;
	}

}
