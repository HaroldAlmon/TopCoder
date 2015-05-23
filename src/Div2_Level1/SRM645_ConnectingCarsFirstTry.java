package Div2_Level1;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class SRM645_ConnectingCarsFirstTry {
	public long minimizeCost(int[] positions, int[] lengths)  {
/*		int cost = 0;
		find the starting position of the car nearest the center {
		}*/
		
		int cost = 0;
		int[] sortPos = Arrays.copyOf(positions, positions.length);
		Arrays.sort(sortPos);
		
		//if ( (sortPos.length % 2) == 1) {
			int middleCar = sortPos.length / 2;
			System.out.printf("middle car position = %d\n", middleCar);
		//}
		
		for (int i = middleCar; i > 0; i--) {
			int diff;
			diff = positions[i] - (positions[i-1] + lengths[i-1]);
			positions[i-1] += diff;
			cost += diff;
			System.out.printf("xdiff = %d\n", diff);
		}
		
		for (int i = middleCar; i < positions.length - 1; i++) {
			int diff;
			//diff = positions[i] - (positions[i-1] + lengths[i-1]);
			diff = positions[i+1] - (positions[i] + lengths[i]);
			positions[i-1] += diff;
			cost += diff;
			System.out.printf("ydiff = %d\n", diff);
		}
		/* 
		move the cars on the left to the center car 
		move the cars on th right to the center care */
		return cost;
	}
	
	private void normalizeCars(int[] positions, int[] lengths) {
		// Change the length of each car to 0 and adjust the cars' starting positions...
		for (int i = 0; i < positions.length; i++) {
			for (int j = i+1; j < positions.length; j++) {
				// Move all the cars to the right to the left...
				positions[j] -= lengths[i];
			}
		}
	}
	
	@Test
	public void test1() {
		int[] positions = {1, 3, 10, 20}; 
		int[] lengths = {2, 2, 5, 3};
		assertTrue(minimizeCost(positions, lengths) == 15);
	}
	
	@Test
	public void test2() {
		int[] positions = {100, 50, 1}; 
		int[] lengths = {10, 2, 1};
		assertTrue(minimizeCost(positions, lengths) == 96);
	}
	
}

