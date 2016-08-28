package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
// SRM 648 Div I - 250
public class SRM648_AB {
	private static int testNo = 1;
	public String createString(int N, int K) {
		//String result = "";
		
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
		
		// Generate all the possible string with A and B.
		for(int j = 0; j < Math.pow( 2, s.length() ); j++) {
			//System.out.println(s);
			if(isMatch(s, K)) {
				return s.toString();
			}
			
			// Implement binary addition...
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'A') {
					// A(?) + A = B(?) with no carry to next digit...
					s.replace(i, i+1, "B");
					break;
				} else {
					// B(?) + A = A(?+B) with carry to next digit...
					s.replace(i, i+1, "A");
				}
			}
		}

		return "";
	}
	
	private boolean isMatch(StringBuilder s, int K) {
		int total = 0;
		for(int i = 0; i < s.length() - 2; i++) {
			if(s.charAt(i) == 'A') {
				for(int j=i+1; j < s.length(); j++) {
					if( s.charAt(j) == 'B' ) {
						total += 1;
					}
				}
			}
		}
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
		String result = createString(3,2);
		System.out.printf("test %d, result(3,2)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "ABB" ));
	}
	
	@Test
	public void test2() {
		String result = createString(2,0);
		System.out.printf("test %d, resul(2,0)t=[%s]\n", testNo++, result);
		assertTrue(result.equals( "AA" ));
	}
	
	@Test
	public void test3() {
		String result = createString(5,8);
		System.out.printf("test %d, result(5,8)=[%s]\n", testNo++, result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test4() {
		String result = createString(10, 12);
		System.out.printf("test %d, result(10,12)=[%s]\n", testNo++, result);
		assertTrue(result.equals( "AAAABBBAAA" ));
	}
}


