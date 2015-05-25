package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM649_DecipherableEasy {
	public String check(String s, String t) {
		if (s.length() != t.length() + 1 ) return "Impossible";
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				//return s.substring(i + 1).equals(t.substring(i)) ? "Possible" : "Impossible";
				// regionMatches() faster than substring...
				return s.regionMatches( (i + 1), t.substring(i), i, t.length() - i) ? "Possible" : "Impossible";
			}
		}
		return "Possible";
	}
	@Test
	public void test4 () {
		assertTrue(check("snukent", "snuke").equals("Impossible"));
	}
	
	@Test
	public void harold5() {
		assertTrue(check("a", "aaaaaaa").equals("Impossible"));
	}
}
