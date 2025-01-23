package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.Duration;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@AllArgsConstructor

public class Athlete {
	@JsonIgnore
	private int competitionNumber;

	@JsonProperty("name")
	private String name;

	@JsonIgnore
	private CountryCode country;

	@JsonProperty("timeResult")
	private TimeResult skiTimeResult;

	@JsonIgnore
	private String shootingResult;

	public Athlete() {}

	/**
	 * Update time with penalties.
	 * Uses the Duration class from java.time.Duration and creates a duration of minute plus seconds (from the time result of every athlete).
	 * Iterates the shooting results and adds 10 seconds for every "o" letter found.
	 * @return the updated time after penalties
	 */
	public Duration updateTimeWithPenalties() {

		Duration updatedTime = Duration.ofMinutes(skiTimeResult.getMinutes()).plusSeconds(skiTimeResult.getSeconds());

		for (int i = 0; i < shootingResult.length(); i++) {
			char xOro = shootingResult.charAt(i);
			if (xOro == 'o') {
				updatedTime = updatedTime.plusSeconds(10);
			}
		}
		return updatedTime;
	}

	/**
	 * Gets missed shots.
	 * Iterates the shooting results and counts the "o" letters, for missing shots.
	 * @return the missed shots
	 */

	@JsonIgnore
	public int getMissedShots() {
		int missedShots = 0;
		for (int i = 0; i < shootingResult.length(); i++) {
			char xOro = shootingResult.charAt(i);
			if (xOro == 'o') {
				missedShots++;
			}
		}
		return missedShots;
	}

	@Override
	public String toString() {
		return name + " " + skiTimeResult;
	}
}
