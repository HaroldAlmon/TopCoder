package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

 
public class SRM650_TaroJiroDividing {
	public int getNumber(int A, int B) {
		int result = 0;
		Set<Integer> set = new HashSet<Integer>();
		while(true) {
			set.add(A);
			if(A % 2 != 0) break;
			A >>= 1;
		}
		while(true) {
			if ( set.contains(B)) result++;
			if(B % 2 != 0) break;
			B >>= 1;
		}
		return result;
	} 
	
	@Test
	public void test1() {
		assertTrue(getNumber(8,4) == 3);
	}
	
	@Test
	public void test2() {
		assertTrue(getNumber(7,4) == 0);
	}
	
	
	@Test
	public void test3() {
		assertTrue(getNumber(12,12) == 3);
	}
	
	
	@Test
	public void test4() {
		assertTrue(getNumber(24,96) == 4);
	}
	
	
	@Test
	public void tes54() {
		assertTrue(getNumber(1000000000,999999999) == 0);
	}

	
	@Before
	public void msg() {
		System.out.println("------------------running test ");
	}
}
