package org.example;

import lombok.Getter;

@Getter
public class TimeResult {
	private int minutes;
	private int seconds;

	public TimeResult(int minutes, int seconds) {
		this.minutes = minutes;
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return minutes + ":" + seconds;
	}
}
