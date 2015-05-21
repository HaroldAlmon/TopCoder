package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SRM639_ElectronicPetEasy {
	public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
		Set<Integer> feedingTime = new HashSet<>();
		for( int i=st1; i < st1 + p1 * t1; i += p1) {
			feedingTime.add(i);
			//System.out.printf("Added %d\n", i);
		}
		for( int i=st2; i < st2 + p2 * t2; i += p2) {
			if( feedingTime.contains(i) ){
				return "Difficult";
			}
		}
		return "Easy";
	}
	
	@Test
	public void test1() {
		assertTrue(isDifficult(3, 3, 3, 5, 2, 3) == "Difficult");
		assertTrue(isDifficult(3, 3, 3, 5, 2, 2) == "Easy");
		assertTrue(isDifficult(1, 4, 6, 1, 4, 7) == "Difficult");
		assertTrue(isDifficult(1, 1000, 1000, 2, 1000, 1000) == "Easy");
		assertTrue(isDifficult(1, 1, 1, 2, 2, 2) == "Easy");
	}
}
