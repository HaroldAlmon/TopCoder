package Div2_Level1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM631_TaroGrid {
	public int getNumber(String[] grid) {
		int result = 0;
		result = Math.max(maxInRows(grid), maxInColumns(grid) );
		return result;
	}
	
	private int maxInRows(String[] grid) {
		int max = 0;
		for (int row = 0; row < grid.length; row++) {
			int whiteCount;
			int blackCount;
			whiteCount = 0;
			blackCount = 0;
			char[] letters = grid[row].toCharArray();
			for (int rowPosition = 0; rowPosition < letters.length; rowPosition++) {
				if(letters[rowPosition] == 'W') {
					whiteCount++;
					blackCount = 0;
				} else {
					blackCount++;
					whiteCount = 0;
				}
			}
			max = Math.max(max, Math.max(whiteCount, blackCount));
		}
		return max;
	}
	
	private int maxInColumns(String[] grid) {
		int max = 0;
		for (int column = 0; column < grid[0].length(); column++) {
			int whiteCount;
			int blackCount;
			whiteCount = 0;
			blackCount = 0;
			for (int row = 0; row < grid.length; row++) {
				if(grid[row].charAt(column) == 'W') {
					whiteCount++;
					blackCount = 0;
				} else {
					blackCount++;
					whiteCount = 0;
				}
			}
			max = Math.max(max, Math.max(whiteCount, blackCount));
		}
		return max;
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
