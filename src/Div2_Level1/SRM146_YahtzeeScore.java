package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

// Passed TopCoder System Test 5/24/2015
public class SRM146_YahtzeeScore {
	public int maxPoints(int[] toss) {
		int maxValue = 0;

		// Map contains dice value (key) and sum of dice values (value).
		HashMap<Integer, Integer> TossSum = new HashMap<>();
		
		for(int tossNum=0; tossNum < toss.length; tossNum++) {
			if (TossSum.containsKey(toss[tossNum])) {
				TossSum.put(toss[tossNum], TossSum.get(toss[tossNum]) + toss[tossNum]);
			}
			else {
				TossSum.put(toss[tossNum], toss[tossNum]);
			}
		}
		
		// This is an easier way to get the max value.
		maxValue = Collections.max(TossSum.values()); 

		return maxValue;
	}
}

