package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SRM645_BacteriesColony {
	public int[] performTheExperiment(int[] colonies) {
		boolean changed = false;
		int[] copy1 = Arrays.copyOf(colonies, colonies.length);
		int[] copy2 = Arrays.copyOf(colonies, colonies.length);
		do {
			changed = false;
			for (int i = 0; i < colonies.length - 2; i++) {
				if (copy1[i + 1] > copy1[i]
						&& copy1[i + 1] > copy1[i + 2]) {
					changed = true;
					copy2[i + 1]--;
				}

				if (copy1[i + 1] < copy1[i]
						&& copy1[i + 1] < copy1[i + 2]) {
					changed = true;
					copy2[i + 1]++;
				}
			}
			copy1 = copy2;
			copy2 = Arrays.copyOf(copy1, copy1.length);
		} while (changed);
		return copy1;
	}
	
	@Test
	public void test1() {
		int[] p = {5, 3, 4, 6, 1 };
		int[] result = {5, 4, 4, 4, 1 };
		assertTrue( Arrays.equals(performTheExperiment(p), result) );
	}
	
	@Test
	public void test2() {
		int[] p = { 1, 5, 4, 9 };
		int[] result = { 1, 4, 5, 9 };
		assertTrue(Arrays.equals(performTheExperiment(p), result));
	}

	@Test
	public void test3() {
		int[] p = { 78, 34, 3, 54, 44, 99 };
		int[] result = { 78, 34, 34, 49, 49, 99 };
		assertTrue(Arrays.equals(performTheExperiment(p), result));
	}
	
	@Test
	public void test4() {
		int[] p = {78, 34, 3, 54, 44, 99 };
		int[] result = {78, 34, 34, 49, 49, 99 };
		assertTrue(Arrays.equals(performTheExperiment(p), result));
	}
	
	@Test
	public void test5() {
		int[] p = {32, 68, 50, 89, 34, 56, 47, 30, 82, 7, 21, 16, 82, 24, 91 };
		int[] result = {32, 59, 59, 59, 47, 47, 47, 47, 47, 18, 18, 19, 53, 53, 91 };
		assertTrue(Arrays.equals(performTheExperiment(p), result));
	}
}
