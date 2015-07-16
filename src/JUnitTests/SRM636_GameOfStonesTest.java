package JUnitTests;
// TODO: Convert this fiel to a JUNit test
import static org.junit.Assert.*;
import Div2_Level1.SRM636_GameOfStones;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/** Passed TopCoder System Test 05/29/2015 */

@RunWith(Parameterized.class)
public class SRM636_GameOfStonesTest {
	int[] input;
	int result;
	private static SRM636_GameOfStones sRM636_GameOfStones = new SRM636_GameOfStones();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{new int[] {7, 15, 9, 5},			 3},
			{new int[] {17},					 0},
			{new int[] {10, 16},				-1},
			{new int[] {2, 6},					 1},
			{new int[] {2, 8, 4},				-1},
			{new int[] {10, 15, 20, 12, 1, 20}, -1},
			{new int[] {17},					 0},
			{new int[] {2, 6},					 1},
			{new int[] {2, 8, 4},				-1},
			{new int[] {10, 15, 20, 12, 1, 20}, -1},
			{new int[] {17, 1, 27, 29, 13, 1, 27, 3, 19, 3, 25, 1, 11, 9, 7, 17, 31, 25, 5, 11, 31, 9, 15, 3, 3, 
					3, 11, 11, 1, 41, 5, 95, 7, 3, 41, 31, 7, 13, 15, 5, 17, 3, 9, 3, 11, 27, 1, 23, 15, 5, 43, 
					11, 17, 7, 1, 3, 13, 69, 3, 43, 21, 1, 25, 1, 3, 11, 5, 43, 13, 7, 15, 1, 1, 55, 37, 9, 5, 
					7, 21, 3, 23, 15, 1, 9, 3, 35, 13, 17, 7, 17, 27, 5, 9, 19, 13, 1, 1, 1, 29}, 277}
		});
	}

public SRM636_GameOfStonesTest(int[] input, int result) {
	this.input = input;
	this.result = result;
}

@Test
public void gameOfStonesTest() {
	assertEquals( result, sRM636_GameOfStones.count(input));
}
}
