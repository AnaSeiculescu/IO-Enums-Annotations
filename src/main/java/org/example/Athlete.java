package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Athlete {

	private int number;
	private String name;
	private CountryCode country;
	private TimeResult skiTimeResult;
	private String shootingResult;

//	public Athlete(String name) {
//		this.name = name;
//	}

	public Duration updateTimeWithPenalties() {

		Duration updatedTime  = Duration.ofMinutes(skiTimeResult.getMinutes()).plusSeconds(skiTimeResult.getSeconds());

		for (int i = 0; i < shootingResult.length(); i++) {
			char xOro = shootingResult.charAt(i);
			if (xOro == 'o') {
				updatedTime = updatedTime.plusSeconds(10);
			}
		}
		return updatedTime;
	}

}
