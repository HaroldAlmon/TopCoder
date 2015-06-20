package Div2_Level1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// Passed TopCoder System Test 5/25/2015
public class SRM631_TaroGrid {
	public int getNumber(String[] grid) {
		int maxCount = 0;
		for (int column = 0; column < grid[0].length(); column++) {
			int whiteCount;
			int blackCount;

			whiteCount = 0;
			blackCount = 0;
			for (int row = 0; row < grid.length; row++) {
				if(grid[row].charAt(column) == 'W') {
					whiteCount++;
					maxCount = Math.max(maxCount, whiteCount);
					blackCount = 0;
				} else {
					blackCount++;
					maxCount = Math.max(maxCount, blackCount);
					whiteCount = 0;
				}
			}
		}
		return maxCount;
	}

	@Test
	public void test1() {
		String[] a = {"W"};
		assertEquals( 1, getNumber(a) );
		
		String[] b = {
				"WB",
				"BW"};
		assertEquals( 1, getNumber(b) );
		
		String[] c = {
				"BWW",
				"BBB",
				"BWB"};
		assertEquals( 3, getNumber(c) );
		
		String[] d = {
				"BWBW",
				"BBWB",
				"WWWB",
				"BWWW"};
		assertEquals( 3, getNumber(d) );
		
		String[] e = {
				"BWBW",
				"BWWB",
				"WWWB",
				"BWWW"};
		assertEquals( 4, getNumber(e) );
		
		String[] f = {
				"BWBW",
				"BWWB",
				"WBBW",
				"BWBW"};
		assertEquals( 2, getNumber(f) );
	}

}

