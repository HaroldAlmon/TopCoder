package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM631_TaroGrid {
	public int getNumber(String[] grid) {
		int result = 0;
		result = Math.max(maxX(grid), maxY(grid) );
		return result;
	}
	
	// find max W or B count in a string...
	private int maxX(String[] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			int countW;
			int countB;
			countW = 0;
			countB = 0;
			char[] ga = grid[i].toCharArray();
			for (int j = 0; j < ga.length; j++) {
				if(ga[j] == 'W') {
					countW++;
				} else
					countB++;
			}
			max = Math.max(max, Math.max(countW, countB));
		}
		return max;
	}
	
	private int maxY(String[] grid) {
		int max = 0;
		for (int i = 0; i < grid[0].length(); i++) {
			int countW;
			int countB;
			countW = 0;
			countB = 0;
			for (int j = 0; j < grid.length; j++) {
				if(grid[j].charAt(i) == 'W') {
					countW++;
				} else
					countB++;				
			}
			max = Math.max(max, Math.max(countW, countB));
		}
		return max;
	}

	@Test
	public void test1() {
		String[] a = {"W"};
		assertTrue( getNumber(a)  == 1);
		
		String[] b = {
				"WB",
				"BW"};
		assertTrue( getNumber(b)  == 1);
		
		String[] c = {
				"BWW",
				"BBB",
				"BWB"};
		assertTrue( getNumber(c)  == 3);
		
		String[] d = {
				"BWBW",
				"BBWB",
				"WWWB",
				"BWWW"};
		assertTrue( getNumber(d)  == 3);
		
		String[] e = {
				"BWBW",
				"BWWB",
				"WWWB",
				"BWWW"};
		assertTrue( getNumber(e)  == 4);
	}
}
