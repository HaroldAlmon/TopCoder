package Div2_Level1;

// SRM 648 Div 2 - 1000 Point
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
// TopCoder.com   SRM 648 

// This solution is too slow.
// Find a better algorithm, maybe use combinations to generate the strings.
public class SRM648_ABC {
	private static int testNo = 1;
	public String createString(int N, int K) {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			s.append("A");
		}
		
		// This loop just like binary addition except the
		// 0 and 1 are replaced by A and B.
		//
		// Also, the number is in little endian format.
		//
		// This could also be coded in big endian format.
		
		// Generate all the possible strings with A, B, and C.
		int limit;
		limit = (int) Math.pow( 3, s.length() );
		for(int j = 0; j < limit; j++) {
			//System.out.println(s);
			if(isMatch(s, K)) {
			//if(isMatch2(s.toString().toCharArray(), K)) {			
				return s.toString();
			}
			
			// Implement binary addition...
			for (int i = 0;  i < s.length(); i++) {
				if(s.charAt(i) == 'A') {
					// A(?) + A = B(?) with no carry to next digit (need break;)...
					s.replace(i, i+1, "B");
					break;
				} else if (s.charAt(i) == 'B') {
					// B(?) + A = C(?) with no carry to next digit (need break;)...
					s.replace(i, i+1, "C");
					break;					
				}
				else {
					// B(?) + A = A(?+B) with carry to next digit...
					s.replace(i, i+1, "A");
				}
			}
		}
		return "";
	}
	
	private boolean isMatch(StringBuilder s, int K) {
		int total = 0;
		for(int i = 0; i < s.length() - 1; i++) {
			for(int j=i+1; j < s.length(); j++) {
				if(s.charAt(i) < s.charAt(j)) {
					total += 1;
					if(total > K) {
						return false;
					}
				}
			}
		}
		//System.out.println("total = " + total);
		return K == total;
	}
	
	private boolean isMatch2(char[] s, int K) {
		//char[] sc = s.toCharArray();
		int total = 0;
		for(int i = 0; i < s.length - 1; i++) {
			for(int j=i+1; j < s.length; j++) {
				if(s[i] < s[j]) {
					total += 1;
					if(total > K) {
						return false;
					}
				}
			}
		}
		//System.out.println("total = " + total);
		return K == total;
	}
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting unit test.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finished unit test.");
	}

	@Test
	public void test1() {
		String result = createString(3,3);
		System.out.printf("test %d, result(3,3)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "ABC" ));
	}
	
	@Test
	public void test2() {
		String result = createString(3,0);
		System.out.printf("test %d, resul(3,0)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "AAA" ));
	}
	
	@Test
	public void test3() {
		String result = createString(5,10);
		System.out.printf("test %d, result(5,10)=[%s]\n", testNo++, result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test4() {
		String result = createString(15, 36);
		System.out.printf("test %d, result(15,36)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "AAAAABBBCCBAAAA" ));
	}
	
	@Test
	public void test5() {
		String result = createString(16, 84);
		System.out.printf("test %d, result(16,84)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "AAAAAABBBBBBCCCC" ));
	}
}


