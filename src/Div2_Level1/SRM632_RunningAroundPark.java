package Div2_Level1;

/** Passed TopCoder System Test 05/29/2015 */
public class SRM632_RunningAroundPark {
	public int numberOfLap(int N, int[] d) {
		int laps = 1;
		int lastTree;
		lastTree = d[0];

		for (int treePosition = 1; treePosition < d.length; treePosition++) {
			if(d[treePosition] <= lastTree)
				laps++;
			lastTree = d[treePosition];
		}

		return laps;
	}
}
