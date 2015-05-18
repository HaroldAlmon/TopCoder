package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SRM637_GreaterGameDiv2 {
	public int calc(int[] snuke, int[] sothe) {
		int result = 0;
		for (int digitIndex = 0; digitIndex < sothe.length; digitIndex++) {
			if(snuke[digitIndex] > sothe[digitIndex]) {
				result++;
			}
		}
		return result;
	}

	@Test
	public void test1() {
		int[] a = {1,3};
		int[] b = {4,2};
		assertTrue( calc(a, b) == 1);

		int[] c = {1,3,5,7,9};
		int[] d = {2,4,6,8,10};
		assertTrue( calc(c, d) == 0);
		
		int[] e = {2};
		int[] f = {1};
		assertTrue( calc(e, f) == 1);

		int[] g = {3,5,9,16,14,20,15,17,13,2};
		int[] h = {6,18,1,8,7,10,11,19,12,4};
		assertTrue( calc(g, h) == 6);
	}
}
