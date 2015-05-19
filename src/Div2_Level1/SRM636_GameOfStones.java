package Div2_Level1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SRM636_GameOfStones {
	public int count(int[] stones) {
		int actionsTotal = 0;
		int stonesSum = 0;
		int movesTotal = 0;

		stonesSum = sumOfStones( stones );

		if ( isStonesSumValid( stones.length, stonesSum ) == false )
			return -1;

		int targetSum = stonesSum / stones.length;

		for ( int stonePos = 0; stonePos < stones.length; stonePos++ ) {
			movesTotal += Math.abs( movesRequiredToReachTargetCount( targetSum, stones[ stonePos]  ) );
		}

		actionsTotal = movesToActions( movesTotal );
		System.out.printf( "%d%n", actionsTotal );
		return actionsTotal;
	}

	private boolean isStonesSumValid(int numberOfPiles, int stonesSum) {
		if( numberOfPiles == 1) 
			return true;
		if( stonesSum % 4 != 0) 
			return false;
		return true;
	}

	private int movesRequiredToReachTargetCount(int targetSum, int pileCount) {
		return ( targetSum - pileCount  ) / 2;
	}

	private int movesToActions(int movesTotal) {
		// Each move on one pile results in a second move on another pile so number of Actions = Moves / 2
		return movesTotal / 2;
	}

	private int sumOfStones(int[] stones) {
		int stonesSum = 0;

		for ( int i = 0; i < stones.length; i++ ) {
			stonesSum += stones[ i ];
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
		assertTrue( count(d) == 1 );
		
		int[] e = {2, 8, 4};
		assertTrue( count(e) == -1 );
		
		int[] f = {10, 15, 20, 12, 1, 20};
		assertTrue( count(f) == -1 );
	}

}
