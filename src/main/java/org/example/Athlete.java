package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Athlete {

	private int number;
	private String name;
	private CountryCode country;
	private TimeResult skiTimeResult;
	private String firstShooting;
	private String secondShooting;
	private String thirdShooting;

	public Athlete(String name) {
		this.name = name;
	}

}
