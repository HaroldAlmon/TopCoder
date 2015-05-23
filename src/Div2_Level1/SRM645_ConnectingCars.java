package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


// This fails the Topcoder system test...
public class SRM645_ConnectingCars {
	public long minimizeCost(int[] positions, int[] lengths)  {
/*		int cost = 0;
		find the starting position of the car nearest the center {
		}*/
		
		int cost = 0;
		//System.out.printf("Initial position of cars %s\n", Arrays.toString(positions));
		
		// Sort the cars by position...
		sortCars(positions, lengths);
		//System.out.printf("sorted %s\n", Arrays.toString(positions));
		
		// Normalize the cars with a length of zero...
		normalizeCars(positions, lengths);
		//System.out.printf("normalized %s\n", Arrays.toString(positions));
	
		int middleCar = positions.length / 2;
		//System.out.printf("middle car position = %d\n", middleCar);
		
		// Calculate cost of moving the cars on the left to the center car...
		for (int i = middleCar; i > 0; i--) {
			int diff;
			diff = positions[middleCar] - positions[i-1];
			cost += diff;
			//System.out.printf("left diff = %d\n", diff);
		}
		
		// Calculate cost of moving the cars on the right to the center car...
		for (int i = middleCar; i < positions.length - 1; i++) {
			int diff;
			diff = positions[i+1] - positions[middleCar];
			cost += diff;
			//System.out.printf("right diff = %d\n", diff);
		}
		/* 
 
		 */
		System.out.printf("cost = %d\n", cost);
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
	
	private void sortCars(int[] positions, int[] lengths) {
		int len;
		int pos;
		Map<Integer, Integer> cars = new TreeMap<>();
		for (int i = 0; i < positions.length; i++) {
			cars.put(positions[i], lengths[i]);
		}
		Set<Integer> set = cars.keySet();
		Iterator<Integer> iter = set.iterator();
		for (int i = 0; i < positions.length; i++) {
			pos = iter.next();
			len = cars.get(pos);
			positions[i] = pos;
			lengths[i] = len;
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
	
	
	@Test
	public void test3() {
		int[] positions = {4, 10, 100, 13, 80}; 
		int[] lengths = {5, 3, 42, 40, 9};
		assertTrue(minimizeCost(positions, lengths) == 66);
	}
	
	
	@Test
	public void test4() {
		int[] positions = {5606451, 63581020, 81615191, 190991272, 352848147, 413795385, 468408016, 615921162, 760622952, 791438427}; 
		int[] lengths = {42643329, 9909484, 58137134, 99547272, 39849232, 15146704, 144630245, 604149, 15591965, 107856540};
		assertTrue(minimizeCost(positions, lengths) == 1009957100);
	}
	
}

