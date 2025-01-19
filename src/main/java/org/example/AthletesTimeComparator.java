package org.example;

import java.util.Comparator;

public class AthletesTimeComparator implements Comparator <Athlete>{

	@Override
	public int compare(Athlete athlete1, Athlete athlete2) {

		return athlete1.updateTimeWithPenalties().compareTo(athlete2.updateTimeWithPenalties());

//		if (athlete1.getSkiTimeResult().getMinutes() == athlete2.getSkiTimeResult().getMinutes()) {
//			return Integer.compare(athlete1.getSkiTimeResult().getSeconds(), athlete2.getSkiTimeResult().getSeconds());
//		}
//		return Integer.compare(athlete1.getSkiTimeResult().getMinutes(), athlete2.getSkiTimeResult().getMinutes());
	}
}
