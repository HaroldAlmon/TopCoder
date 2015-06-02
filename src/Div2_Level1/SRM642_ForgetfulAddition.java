package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SRM642_ForgetfulAddition {
	int minNumber( String expression ) {
		int minimumSum = Integer.MAX_VALUE;
		
		for ( int digitIndex = 1; digitIndex < expression.length(); digitIndex++ ) {
			int int1;
			int int2;
			int total; 
			
			int1 = Integer.parseInt( expression.substring( 0, digitIndex) );
			int2 = Integer.parseInt( expression.substring( digitIndex, expression.length() ) );

			total = int1 + int2;
			
			if ( total < minimumSum )
				minimumSum = total;
		}

		return minimumSum;
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


