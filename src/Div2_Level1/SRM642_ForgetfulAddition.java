package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM642_ForgetfulAddition {
	int minNumber(String expression) {
		int result = Integer.MAX_VALUE;
		
		for (int i = 1; i < expression.length(); i++) {
			int int1;
			int int2;
			int total; 
			
			int1 = Integer.parseInt(expression.substring(0, i));
			int2 = Integer.parseInt(expression.substring(i, expression.length()));

			total = int1 + int2;
			
			System.out.printf("int1 = %d, int2 = %d\n", int1, int2);
			
			if (total < result)
				result = total;
		}

		return result;
	}

	@Test
	public void test1() {
		assertTrue(minNumber("22") == 4 );
	}
	
	@Test
	public void test2() {
		assertTrue(minNumber("123") == 15 );
	}
	
	@Test
	public void test3() {
		assertTrue(minNumber("1289") == 101 );
	}
	
	@Test
	public void test4() {
		assertTrue(minNumber("31415926") == 9067 );
	}

	@Test
	public void test5() {
		assertTrue(minNumber("98765") == 863 );
	}
}


