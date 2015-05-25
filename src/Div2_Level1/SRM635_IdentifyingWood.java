package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//Passed TopCoder System Test 5/25/2015
public class SRM635_IdentifyingWood {
	private final String YES = "Yep, it's wood.";
	private final String NO = "Nope.";

	public String check(String s, String t) {
		String result = NO;
		
		// Create aliases for s and t...
		String sourceDigits = s;
		String targetDigits = t;
		
		int sourcePos = 0;
		int targetPos = 0;

		for (; targetPos < targetDigits.length(); targetPos++) {
			boolean found;

			found = false;
			for (; sourcePos < sourceDigits.length(); sourcePos++) {
				if(targetDigits.charAt(targetPos) == sourceDigits.charAt(sourcePos)) {
					found = true;
					sourcePos++;
					break;		
				}
			}
			if (found == false) 
				break;
		}
		result = (targetPos == targetDigits.length()) ? YES : NO;
		return result;
	}

	@Test
	public void IdentifyingWood() {	
		assertTrue( check("absdefgh", "asdf").equals(YES) );
		assertTrue( check("oxoxoxox", "ooxxoo").equals(NO) );
		assertTrue( check("oxoxoxox", "xxx").equals(YES) );
		assertTrue( check("qwerty", "qwerty").equals(YES) );
		assertTrue( check("string", "longstring").equals(NO) );
	}
}
