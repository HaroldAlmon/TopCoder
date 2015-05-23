package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SRM646_TheConsecutiveIntegersDivTwo {
	public int find(int[] numbers, int k) {
		int min = Integer.MAX_VALUE;
		if (k == 1 ) return 0;
			for (int i = 0; i < numbers.length - 1; i++) {
				for(int j = i + 1; j < numbers.length; j++) {
					System.out.printf("pair = (%d, %d)\n", numbers[i], numbers[j]);
					int steps;
					steps = Math.abs(numbers[i] - numbers[j]) - 1;
					if (steps < min) {
						min = steps;
					}
				}
			}
		System.out.println("Min = " + min);
		return min;
	}
	
	@Test
	public void test1() {
		int[] a = {4, 47, 7};
		assertTrue( find(a, 2) == 2);
	}
	
	@Test
	public void test2() {
		int[] a = {1, 100};
		assertTrue( find(a, 1) == 0);
	}
	
	@Test
	public void test3() {
		int[] a = {-96, -53, 82, -24, 6, -75};
		assertTrue( find(a, 2) == 20);
	}
	
	@Before
	public void before() {
		System.out.println("-------------------------");
	}
}

