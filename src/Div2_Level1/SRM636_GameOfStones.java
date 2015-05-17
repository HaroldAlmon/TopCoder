package Div2_Level1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SRM636_GameOfStones {
	public static void main(String[] args) {
		SRM636_GameOfStones main = new SRM636_GameOfStones();
		main.test1();
	}
	
	public int count(int[] stones) {
		int actionsTotal = 0;
		int stonesSum = 0;

		stonesSum = sumOfStones( stones );

		if ( isStonesSumValid( stones.length, stonesSum ) == false )
			return -1;
		
		int targetSum = stonesSum / stones.length;
		
		for ( int stonePos = 0; stonePos < stones.length; stonePos++ ) {
			actionsTotal += Math.abs( movesRequiredToReachTargetCount(targetSum, stones[ stonePos]  ) );
		}

		// Each move adjusts the count on 2 piles, so cut the moves in half...
		actionsTotal = movesToActions(actionsTotal);

		System.out.printf( "%d%n", actionsTotal );
		return actionsTotal;
	}

	private int movesToActions(int actionsTotal) {
		return actionsTotal / 2;
	}

	private int movesRequiredToReachTargetCount(int targetSum, int pileCount) {
		return ( targetSum - pileCount  ) / 2;
	}

	private boolean isStonesSumValid(int numberOfPiles, int stonesSum) {
		if( numberOfPiles == 1) 
			return true;
		if( stonesSum % 4 != 0) 
			return false;
		return true;
	}

	private int sumOfStones(int[] stones) {
		int stonesSum = 0;

		for ( int i = 0; i < stones.length; i++ ) {
			stonesSum += stones[ i ];
		}

		return stonesSum;
	}

	@Test
	public void test1() {	
		int[] a = {7, 15, 9, 5};
		assertEquals( 3, count(a) );

		int[] b = {17};
		assertTrue( count(b) == 0 );
		
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
