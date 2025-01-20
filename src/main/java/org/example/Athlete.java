package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@AllArgsConstructor

public class Athlete {
	private int competitionNumber;
	private String name;
	private CountryCode country;
	private TimeResult skiTimeResult;
	private String shootingResult;

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

	public int getMissedShots() {
		int missedShots = 0;
		for (int i = 0; i < shootingResult.length(); i++) {
			char xOro = shootingResult.charAt(i);
			if (xOro == 'o') {
				missedShots ++;
			}
		}
		return missedShots;
	}

	@Override
	public String toString() {
		return name + " " + skiTimeResult;
	}
}
