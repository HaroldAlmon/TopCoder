package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM648_KitayutaMart {
	public int numBought(int K, int T) {
		System.out.printf("Total = %d Apples Count = %d%n", T,  ( int )( Math.log((double)( T + K) / K) / Math.log( 2.0 )));
		return ( int )( Math.log( (T + K) / K ) / Math.log( 2.0 ) );
	}
	
	@Test
	public void test1() {
		assertTrue(numBought(100,100) == 1);
	}
	
	@Test
	public void test2() {
		assertTrue(numBought(100,300) == 2);
	}
	
	@Test
	public void test3() {
		assertTrue(numBought(150, 1050) == 3);
	}
	
	@Test
	public void test4() {
		assertTrue(numBought(160, 163680) == 10);
	}
}


