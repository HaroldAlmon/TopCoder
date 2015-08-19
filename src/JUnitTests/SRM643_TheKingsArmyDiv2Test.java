package JUnitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM643_TheKingsArmyDiv2Test {
	public int getNumber(String[] state)  {
		boolean found = false;
		
		if ( state[0].indexOf("HH") >= 0) 
			// Foundhappy soldiers...
			return 0;
		
		if ( state[0].indexOf("H") >= 0) 
			found = true;
		
		for (int i = 1; i < state.length; i++) {
			// Found a pair BESIDE eachother...
			if ( state[i].indexOf("HH") >= 0) 
				return 0;

			// check the current and previous row...
			for (int j = 0; j < state[i].length(); j++) {
				if (state[i].charAt(j) == 'H' &&  state[i-1].charAt(j) == 'H') 
					return 0;
			}
			
			// Found a single soldier...
			if ( state[i].indexOf("H") >= 0) 
				found = true;
		}
		// If at least one soldier, need to add one more, else add two...
		return found == true ? 1 : 2;
	}
	@Test
	public void test1() {
		String[] s = 
		{"SSSSS",
		"SSHHS",
		"SSSSS"};

		assertTrue( getNumber(s) == 0);
	}
	
	@Test
	public void test2() {
		String[] s = 
			{"SSSSS",
			"SSHSH",
			"HSSSS"};

		assertTrue( getNumber(s) == 1);
	}
	
	
	@Test
	public void test3() {
		String[] s = 
			{"SSS",
				 "SSS",
				 "SSS"};

		assertTrue( getNumber(s) == 2);
	}
	
	@Test
	public void test4() {
		String[] s = 
			{"HSHSHSH", 
				 "SSSHSSS", 
				 "SSHSHSS", 
				 "SHSHSHS"};

		assertTrue( getNumber(s) == 1);
	}
	
	
	@Test
	public void test5() {
		String[] s = 
			{"HHSH", 
				 "HHHS", 
				 "HSSS", 
				 "SHSH", 
				 "HHHS", 
				 "HSHH", 
				 "SSSH"};

		assertTrue( getNumber(s) == 0);
	}
	
	@Test
	public void testu1() {
		String[] s = 
		{"HSSS",
		"HSSS",
		"SSSS"};

		assertTrue( getNumber(s) == 0);
	}
	
	@Test
	public void testu2() {
		String[] s = 
		{"SSSS",
		"HSSS",
		"HSSS"};

		assertTrue( getNumber(s) == 0);
	}

	@Test
	public void testu3() {
		String[] s = 
		{"SSSS",
		"SSSH",
		"SSSH"};

		assertTrue( getNumber(s) == 0);
	}
}
