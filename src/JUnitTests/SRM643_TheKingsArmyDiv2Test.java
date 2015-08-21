package JUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM643_TheKingsArmyDiv2;

@RunWith(Parameterized.class)
public class SRM643_TheKingsArmyDiv2Test {
	private String[] matrix;
	private int result;
	private static SRM643_TheKingsArmyDiv2 theKingsArmyDiv2 = new SRM643_TheKingsArmyDiv2();

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
			"SSS"},		2},
		
		{ new String[] 
			{"HSHSHSH", 
			"SSSHSSS", 
		    "SSHSHSS", 
		    "SHSHSHS"}, 1},
			
		{ new String[]  
			{"HHSH", 
			"HHHS", 
			"HSSS", 
			"SHSH", 
			"HHHS", 
			"HSHH", 
			"SSSH"},	0},
		});
	}

	public SRM643_TheKingsArmyDiv2Test(String[] matrix, int result) {
		this.matrix = matrix;
		this.result= result;
	}
	
	@Test
	public void test1() {
		assertEquals( theKingsArmyDiv2.getNumber( matrix ), result ) ;
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
