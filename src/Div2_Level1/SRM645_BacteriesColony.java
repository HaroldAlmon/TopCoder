package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Arrays;

/** Passed TopCoder System Test 5/27/2014 */
public class SRM645_BacteriesColony {
	public int[] performTheExperiment(int[] colonies) {
		boolean colonySizeChanged = false;
		int[] colonyBefore = Arrays.copyOf(colonies, colonies.length);
		int[] colonyAfter = Arrays.copyOf(colonies, colonies.length);
		do {
			colonySizeChanged = false;
			for (int vesselNum = 0; vesselNum < colonies.length - 2; vesselNum++) {
				colonySizeChanged = decreaseColonySize(colonySizeChanged, colonyBefore, colonyAfter, vesselNum);
				colonySizeChanged = increaseColonySize(colonySizeChanged, colonyBefore, colonyAfter, vesselNum);
			}
			colonyBefore = colonyAfter;
			colonyAfter = Arrays.copyOf(colonyBefore, colonyBefore.length);
		} while (colonySizeChanged);
		return colonyBefore;
	}

	private boolean increaseColonySize(boolean colonySizeChanged,
			int[] colonyBefore, 
			int[] colonyAfter, 
			int vesselNum) {
		if (colonyBefore[vesselNum + 1] < colonyBefore[vesselNum]
				&& colonyBefore[vesselNum + 1] < colonyBefore[vesselNum + 2]) {
			colonySizeChanged = true;
			colonyAfter[vesselNum + 1]++;
		}
		return colonySizeChanged;
	}

	private boolean decreaseColonySize(boolean colonySizeChanged,
			int[] colonyBefore, 
			int[] colonyAfter, 
			int vesselNum) {
		if (colonyBefore[vesselNum + 1] > colonyBefore[vesselNum]
				&& colonyBefore[vesselNum + 1] > colonyBefore[vesselNum + 2]) {
			colonySizeChanged = true;
			colonyAfter[vesselNum + 1]--;
		}
		return colonySizeChanged;
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
