package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM635_IdentifyingWood {
	private String yes = "Yep, it's wood";
	private String no = "Nope";
	public String check(String s, String t) {

		String result = no;
		
		int j = 0;
		int i = 0;
		boolean found = false;
		for (; i < t.length(); i++) {
			found = false;
			for (; j < s.length(); j++) {
				if(t.charAt(i) == s.charAt(j)) {
					found = true;
					j++;
					break;		
				}
			}
			if (found == false) 
				break;
		}
		result = (i == t.length()) ? yes : no;
		return result;
	}

	@Test
	public void test1() {	
		assertTrue( check("absdefgh", "asdf").equals(yes) );
		assertTrue( check("oxoxoxox", "ooxxoo").equals(no) );
		assertTrue( check("oxoxoxox", "xxx").equals(yes) );
		assertTrue( check("qwerty", "qwerty").equals(yes) );
		assertTrue( check("string", "longstring").equals(no) );
	}
}
