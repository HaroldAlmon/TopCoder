package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SRM636_GameOfStones {
	public static void main(String[] args) {
		SRM636_GameOfStones main = new SRM636_GameOfStones();
		main.test1();
	}
	
	public int count(int[] stones) {
		int result = 0;
		
		int sum = 0;
		
		if (stones.length == 1) return 0; 
		
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		
		if(sum % 4 != 0) return -1;
		
		sum = sum / stones.length;
		
		for (int i = 0; i < stones.length; i++) {
			result += Math.abs((stones[i] - sum)/2);
		}
		result /= 2;
		System.out.printf("%d\n", result);
		return result;
	}

	@Test
	public void test1() {	
		int[] a = {7, 15, 9, 5};
		assertTrue( count(a) == 3 );

		int[] b = {17};
		assertTrue( count(b) == 0 );
		
		int[] c = {10, 16};
		assertTrue( count(c) == -1 );
		
		int[] d = {2, 6};
		assertTrue( count(d) == 1 );
		
		int[] e = {2, 8, 4};
		assertTrue( count(e) == -1 );
		
		int[] f = {10, 15, 20, 12, 1, 20};
		assertTrue( count(f) == -1 );
	}
}
