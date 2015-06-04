package Div2_Level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
// Passed Topcder System Test 05/29/2015
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
		System.out.printf("result=%d%n", laps);
		return laps;
	}

	@Test
	public void RunningAroundPark(){
		int[] a = {1,2,3};
		assertEquals( 1, numberOfLap(3, a) );
	}
	
	@Test
	public void RunningAroundPark2(){
		int[] b = {6,6};
		assertEquals( 2, numberOfLap(3, b) );
	}
	
	@Test
	public void RunningAroundPark3(){
		int[] c = {3,2,1};
		assertEquals( 3, numberOfLap(3, c) );
	}
	
	@Test
	public void RunningAroundPark4(){
		int[] d = {1,3,5,7,9,2,4,6,8,10};
		assertEquals( 2, numberOfLap(3, d) );
	}
}
