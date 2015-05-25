package Div2_Level1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SRM650_TaroFillingAString {
	public int getNumber(String S) {
		return S.charAt(0) == '?'
			? Math.min(score(make("A" + S.substring(1))), score(make("B" + S.substring(1))))
			: score(make(S));
	}
	public String make(String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) == '?') {
				if (sb.charAt(i - 1) == 'A') {
					sb.replace(i, i + 1, "B");
				} else 
					sb.replace(i, i + 1, "A");
			}
		}
		return sb.toString();
	}
	int score(String s) {
		int res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) 
				res++;
		}
		//System.out.printf("S=%s, score = %d\n", s, result);
		return res;
	}
	@Test 
	public void test1() {
		assertTrue( getNumber ("ABAA") == 1 ) ;
	}
	@Test 
	public void test2() {
		assertTrue( getNumber ("??") == 0 ) ;
	}
	@Test 
	public void test3() {
		assertTrue( getNumber ("A?A") == 0 ) ;
	}
	@Test 
	public void test5() {
		assertTrue( getNumber ("A??B???AAB?A???A") == 3 ) ;
	}
	@Test 
	public void test6() {
		for (int i=1; i<100000; i++) 
			assertTrue( getNumber ("?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?") == 10 ) ;
	}
}

