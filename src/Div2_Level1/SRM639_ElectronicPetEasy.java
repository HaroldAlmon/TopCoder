package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

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
	
	@Test(timeout = 500)
	public void test1() {
		assertTrue(isDifficult(3, 3, 3, 5, 2, 3) == "Difficult");
	}
	
	@Test(timeout = 500)
	public void test2() {
		assertTrue(isDifficult(3, 3, 3, 5, 2, 2) == "Easy");
	}

	@Test(timeout = 500)
	public void test3() {
		assertTrue(isDifficult(1, 4, 6, 1, 4, 7) == "Difficult");
	}
	
	@Test(timeout = 500)
	public void test4() {
		assertTrue(isDifficult(1, 1000, 1000, 2, 1000, 1000) == "Easy");
	}
	
	@Test(timeout = 500)
	public void test5() {
		assertTrue(isDifficult(1, 1, 1, 2, 2, 2) == "Easy");
	}
}
