package Div2_Level1;

// SRM 647 Div 2 - 250 Point
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SRM647_PeacefulLine {
	int[] students = {25,12,3,25,25,12,12,12,12,3,25,25,12,3,25,25,12,12,12,12,3,25,1,2,3};

	
	public static int testNo = 1;
	private final int MAX=26;
	public String makeLine(int[] x) {
		
		// Create alias for x...
		int [] studentAge = x;
		int[] result = new int[MAX];
		int freePos = 0;

		if (studentAge == null || studentAge.length >= MAX) {
			System.out.println("impossible");
			return "impossible";
		}
		int[] total = new int[MAX];
		for (int studentPos = 0; studentPos < studentAge.length; studentPos++) {
			if (studentAge[studentPos] <= 0 || studentAge[studentPos] >= MAX) {
				System.out.println("impossible");
				return "impossible";
			}
			total[studentAge[studentPos]]++;
		}

		while(true) {
			int studentPos;
			int first, second;
			first = 0;
			second = 0;
			for (studentPos = 0; studentPos < MAX; studentPos++) {
				if (total[studentPos] > total[first]) {
					first = studentPos;
				}
			}
			result[freePos] = first;
			freePos += 1;

			for (studentPos = 0; studentPos < MAX; studentPos++) {
				if ((total[studentPos] > total[second]) && studentPos != first) {
					second = studentPos;
				}
			}
			result[freePos] = second;
			freePos += 1;
			if( total[second] == 0 ) {
				if (total[first] > 1) {
					return "impossible";
				} else {
					return "possible";
				}
			}
			total[first]--;
			total[second]--;
		}
	}
	
	@Test
	public void test9() {
		int[] students = {25,12,3,25,25,12,12,12,12,3,25,25,12,3,25,25,12,12,12,12,3,25,1,2,3};
		assertTrue(makeLine(students).equals("possible"));
	}

	@Test
	public void test10() {
		int[] students = {2,2,3,3,3};
		assertTrue(makeLine(students).equals("possible"));
	}

	@Test
	public void test1() {
		int[] students = { 1, 2, 3, 4 };
		assertTrue(makeLine(students).equals("possible"));
	}

	@Test
	public void test2() {
		int[] students = { 1, 1, 1, 2 };
		assertTrue(makeLine(students).equals("impossible"));
	}

	@Test
	public void test3() {
		int[] students = {1,1,2,2,3,3,4,4};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test4() {
		int[] students = {3,3,3,3,13,13,13,13};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test5() {
		int[] students = {3,7,7,7,3,7,7,7,3};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test6() {
		int[] students = {25,12,3,25,25,12,12,12,12,3,25};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test7() {
		int[] students = {3,3,3,3,13,13,13,13,3};
		assertTrue(makeLine(students).equals("possible"));
	}

	@Test
	public void test8() {
		int[] students = {};
		assertTrue(makeLine(students).equals("possible"));
	}

	
	@Before
	public void msg() {
		System.out.println("------------------running test ");
	}
	

	
	@Test
	public void test11() {
		int[] students = {2,2,2,3,3};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test12() {
		int[] students = {2,2,2,3,3, 5,5,5,5,5,5,5};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test13() {
		int[] students = {1};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test14() {
		int[] students = {25};
		assertTrue(makeLine(students).equals("possible"));
	}
	
	@Test
	public void test16() {
		int[] students = {26};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test17() {
		int[] students = {25,12,3,25,25,12,12,12,12,3,25,25,12,3,25,25,12,12,12,12,3,25,1,2,3,4};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test18() {
		int[] students = null;
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test19() {
		int[] students = {0};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test20() {
		int[] students = {-1};
		assertTrue(makeLine(students).equals("impossible"));
	}
	
	@Test
	public void test21() {
		int[] students = {1,1,1,1,1,2,2,2,2,2};
		assertTrue(makeLine(students).equals("possible"));
	}
}
