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
}
