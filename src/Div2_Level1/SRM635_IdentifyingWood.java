package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/** Passed TopCoder System Test 05/29/2015 */
public class SRM635_IdentifyingWood {
	private final String YES = "Yep, it's wood";
	private final String NO = "Nope";

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
		assertTrue( check("string", "longstring").equals(NO) );
	}
	
	@Test
	public void IdentifyingWood2() {	
		assertTrue( check("oxoxoxox", "ooxxoo").equals(NO) );
	}
	
	@Test
	public void IdentifyingWood3() {	
		assertTrue( check("oxoxoxox", "xxx").equals(YES) );
	}
	
	@Test
	public void IdentifyingWood4() {	
		assertTrue( check("qwerty", "qwerty").equals(YES) );
	}
	
	@Test
	public void IdentifyingWood5() {	
		assertTrue( check("string", "longstring").equals(NO) );
	}
}
