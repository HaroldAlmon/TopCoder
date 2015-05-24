package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

// Passed TopCoder System Test 5/24/2015
public class SRM146_YahtzeeScore {
	public int maxPoints(int[] toss) {
		int result = 0;

		// Map contains dice value (key) and sum of dice values (value).
		HashMap<Integer, Integer> TossSum = new HashMap<>();
		
		for(int i=0; i < toss.length; i++) {
			if (TossSum.containsKey(toss[i])) {
				TossSum.put(toss[i], TossSum.get(toss[i]) + toss[i]);
			}
			else {
				TossSum.put(toss[i], toss[i]);
			}
		}
		
		// This is an easier way to get the max value.
		result = Collections.max(TossSum.values()); 

		return result;
	}
	
	@Test
	public void test1() {
		int[] toss = { 2, 2, 3, 5, 4 };
		maxPoints( toss );
		assertTrue( maxPoints( toss ) == 5);
	}
	
	@Test
	public void test2() {
		int[] toss = { 6, 4, 1, 1, 3 };
		assertTrue( maxPoints( toss ) == 6);
	}

	@Test
	public void test3() {
		int[] toss = { 5, 3, 5, 3, 3 };
		maxPoints( toss );
		assertTrue( maxPoints( toss ) == 10);
	}
}

