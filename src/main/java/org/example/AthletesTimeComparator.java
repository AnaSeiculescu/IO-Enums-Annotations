package org.example;

import java.util.Comparator;

public class AthletesTimeComparator implements Comparator<Athlete> {

	@Override
	public int compare(Athlete athlete1, Athlete athlete2) {
		return athlete1.updateTimeWithPenalties().compareTo(athlete2.updateTimeWithPenalties());
	}
}
