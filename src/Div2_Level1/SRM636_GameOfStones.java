package Div2_Level1;

import static org.junit.Assert.*;

import org.junit.Test;
/** Passed TopCoder System Test 05/29/2015 */
public class SRM636_GameOfStones {
	public int count(int[] stones) {
		int actionsTotal = 0;
		int stonesSum = 0;
		int movesTotal = 0;

		stonesSum = sumOfStones( stones );

		if ( stonesSum % stones.length != 0 ) {
			return -1;
		}
		int targetSum = stonesSum / stones.length;
		
		for ( int stonePos = 0; stonePos < stones.length; stonePos++ ) {
			movesTotal += Math.abs( ( targetSum - stones[ stonePos]  ) / 2 );
			if ( (targetSum - stones[ stonePos]) % 2 != 0) 
				return -1;
		}

		actionsTotal = movesToActions( movesTotal );
		return actionsTotal;
	}

	private int movesToActions(int movesTotal) {
		// Each move on one pile results in a second move on another pile so number of Actions = Moves / 2
		return movesTotal / 2;
	}

	private int sumOfStones(int[] stones) {
		int stonesSum = 0;

		for ( int position = 0; position < stones.length; position++ ) {
			stonesSum += stones[ position ];
		}

		return stonesSum;
	}
	
	@Test
	public void GameOfStones() {	
		int[] a = {7, 15, 9, 5};
		assertEquals( 3, count(a) );

		int[] b = {17};
		assertEquals( 0, count(b) );
		
		int[] c = {10, 16};
		assertTrue( count(c) == -1 );
		
		int[] d = {2, 6};
		assertEquals( 1, count(d) );
		
		int[] e = {2, 8, 4};
		assertEquals( -1, count(e) );
		
		int[] f = {10, 15, 20, 12, 1, 20};
		assertTrue( count(f) == -1 );
	}
	
	@Test
	public void GameOfStonesb() {
		int[] b = {17};
		assertEquals( 0, count(b) );
	}
	
	public void GameOfStonesc() {	
		int[] c = {10, 16};
		assertTrue( count(c) == -1 );
	}

	@Test
	public void GameOfStonesd() {	
		int[] d = {2, 6};
		assertEquals( 1, count(d) );
	}

	@Test
	public void GameOfStonese() {	
		int[] e = {2, 8, 4};
		assertEquals( -1, count(e) );
	}
	
	@Test
	public void GameOfStonesf() {	
		int[] f = {10, 15, 20, 12, 1, 20};
		assertTrue( count(f) == -1 );
	}
	
	@Test
	public void testg() {
		int[] g =
		{17, 1, 27, 29, 13, 1, 27, 3, 19, 3, 25, 1, 11, 9, 7, 17, 31, 25, 5, 11, 31, 9, 15, 3, 3, 3, 11, 11, 1, 41, 5, 95, 7, 3, 41, 31, 7, 13, 15, 5, 17, 3, 9, 3, 11, 27, 1, 23, 15, 5, 43, 11, 17, 7, 1, 3, 13, 69, 3, 43, 21, 1, 25, 1, 3, 11, 5, 43, 13, 7, 15, 1, 1, 55, 37, 9, 5, 7, 21, 3, 23, 15, 1, 9, 3, 35, 13, 17, 7, 17, 27, 5, 9, 19, 13, 1, 1, 1, 29};
		assertEquals( 277, count(g) );
	}

}
