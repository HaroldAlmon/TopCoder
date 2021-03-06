package Div2_Level1;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

// Passed Topcoder System Test 5/24/2015
public class SRM144_BinaryCode { 
	public String[] decode(String message) {
		String[] result = new String[2];
		
		byte[] Q = new byte[message.length()];
		
		// Convert the encrypted string to a byte array...
		for(int i = 0; i < message.length(); i += 1) {
			Q[i] = Byte.parseByte(message.substring(i, i + 1));
		}
		
		byte[] P = new byte[message.length() + 2];
		
		// P[0] is a guard position outside the encrypted string...
		P[0] = 0;
		P[P.length -1] = 0;

		P[1] = 0;
		result[0] = decrypt(Q, P);

		P[1] = 1;
		result[1] = decrypt(Q, P);

		return result;
	}
	
	String decrypt(byte[] Q, byte[] P) {
		String result = "";
		
		for(int digitPos = 0; digitPos < Q.length; digitPos += 1) {
			P[ digitPos + 2] = (byte) (Q[ digitPos ] - P[ digitPos ] - P[ digitPos + 1 ]);
			if (P[ digitPos + 2 ] > 1 || P[ digitPos + 2 ] < 0) {
				result = "NONE";
				return result;
			}
		}
		
		// The last position in P should be calculated to be zero...
		if ( P[P.length -1] != 0) {
			return "NONE";
		}
		
		for(int digitPos = 1; digitPos < P.length - 1; digitPos += 1) {
			result += Byte.toString(P[ digitPos ]);
		}
		
		return result;
	}
	
	@Test
	public void matchesDecodedValue_00() {
		// Encrypted string...	
		String Q = "00";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[ 0 ], is("00") );
		assertThat( decodedStringIsIncorrect(), result[ 1 ], is("NONE"));
		return;
	}
	
	@Test
	public void matchesDecodedValue_123210122() {
		// Encrypted string...	
		String Q = "123210122";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("011100011"));
		assertThat( decodedStringIsIncorrect(), result[1], is("NONE"));
	}
	
	@Test
	public void matchesDecodedValue_11() {
		// Encrypted string...	
		String Q = "11";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("01"));
		assertThat( decodedStringIsIncorrect(), result[1], is("10"));		
	}
	
	@Test
	public void matchesDecodedValue_22111() { 
		// Encrypted string...	
		String Q = "22111";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("NONE"));
		assertThat( decodedStringIsIncorrect(), result[1], is("11001"));	
	}

	@Test
	public void matchesDecodedValue_123210120() { 
		// Encrypted string...	
		String Q = "123210120";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("NONE"));
		assertThat( decodedStringIsIncorrect(), result[1], is("NONE"));	
	}
	
	@Test
	public void matchesDecodedValue_3() { 
		// Encrypted string...	
		String Q = "3";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("NONE"));
		assertThat( decodedStringIsIncorrect(), result[1], is("NONE"));	
	}

	@Test
	public void matchesDecodedValue_12221112222221112221111111112221111() { 
		// Encrypted string...	
		String Q = "12221112222221112221111111112221111";
	
		String[] result = decode(Q);
		
		assertThat( decodedStringIsIncorrect(), result[0], is("01101001101101001101001001001101001"));
		assertThat( decodedStringIsIncorrect(), result[1], is("10110010110110010110010010010110010"));	
	}	
	
	private String decodedStringIsIncorrect() {
		return "Decoded string is incorrect";
	}
}
