package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM632_RunningAroundPark {
	public int numberOfLap(int N, int[] d) {
		int result = 1;
		int last;
		last = d[0];
		for (int i = 1; i < d.length; i++) {
			if(d[i] <= last)
				result++;
			last = d[i];
		}
		System.out.printf("result=%d\n", result);
		return result;
	}
	@Test
	public void test1(){
		int[] a = {1,2,3};
		assertTrue( numberOfLap(3, a) == 1);
		
		int[] b = {6,6};
		assertTrue( numberOfLap(3, b) == 2);
		
		int[] c = {3,2,1};
		assertTrue( numberOfLap(3, c) == 3);
		
		int[] d = {1,3,5,7,9,2,4,6,8,10};
		assertTrue( numberOfLap(3, d) == 2);
	}
}
