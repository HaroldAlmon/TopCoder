package JUnitTests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SRM643_TheKingsArmyDiv2Test {
	@Parameters
	public static Collection<Object []> getData() {
		return Arrays.asList( new Object[][] {
		{new String[]  
			{"SSSSS",
			"SSHHS",
			"SSSSS"},	0},
		
		{new String[]
			{"SSSSS",
			"SSHSH",
			"HSSSS"},	1},
			
		{ new String[] 
			{"SSS",
			"SSS",
			"SSS"}, 2}	
		});
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
