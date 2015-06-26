package JUnitTests;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SRM637_GreaterGameDiv2Test {
	int cardListSnuke;
	int cardListSothe;

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object[][] {
			{ new int[] {1,3}, 			new int[] {4, 2},		1 },
			{ new int[] {1,3,5,7,9},	new int[] {2,4,6,8,10}, 0 }
		});
	}
	
	// TODO: Add constructor and test.

/*	@Test
	public void test1() {
		int[] e = {2};
		int[] f = {1};
		assertTrue( calc(e, f) == 1);

		int[] g = {3,5,9,16,14,20,15,17,13,2};
		int[] h = {6,18,1,8,7,10,11,19,12,4};
		assertTrue( calc(g, h) == 6);
	}

	@Test
	public void test2() {
		int[] c = {1,3,5,7,9};
		int[] d = {2,4,6,8,10};
		assertTrue( calc(c, d) == 0);
	}
	
	@Test
	public void test3() {
		int[] e = {2};
		int[] f = {1};
		assertTrue( calc(e, f) == 1);
	}
	
	@Test
	public void test4() {
		int[] g = {3,5,9,16,14,20,15,17,13,2};
		int[] h = {6,18,1,8,7,10,11,19,12,4};
		assertTrue( calc(g, h) == 6);
	}*/
}
