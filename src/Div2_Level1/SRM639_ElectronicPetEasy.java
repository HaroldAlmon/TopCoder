package Div2_Level1;

import java.util.HashSet;
import java.util.Set;

//Passed TopCoder System Test on 8/10/2015
public class SRM639_ElectronicPetEasy {
	public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
		Set<Integer> firstFeedingTimes = new HashSet<>();

		for( int secondFeedingTime = st1; secondFeedingTime < st1 + p1 * t1; secondFeedingTime += p1) {
			firstFeedingTimes.add(secondFeedingTime);
		}

		for( int secondFeedingTime=st2; secondFeedingTime < st2 + p2 * t2; secondFeedingTime += p2) {
			if( firstFeedingTimes.contains(secondFeedingTime) ){
				return "Difficult";
			}
		}

		return "Easy";
	}
}
