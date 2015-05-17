package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM631_TaroGrid;

@RunWith(Parameterized.class)
public class SRM631_ParamTests {
	private String[] input;
	private int expectedResult;
	private static SRM631_TaroGrid  srm631_TaroGrid  = new SRM631_TaroGrid ();


	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{ new String[] {"W"}, new Integer[] {1} },
			
			{ new String[] {"WB",
							"BW"}, new Integer[] {1} },
							
			{ new String[] {"BWW",
							"BBB",
							"BWB"}, new Integer[] {3} }
			} );
	}
	
		
	public SRM631_ParamTests(String[] input, Integer[] expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult[0];
	}
	
	@Test(timeout = 500)
	public void srm631_TaroGrid() {
		int result;

		result = srm631_TaroGrid.getNumber(input);
		System.out.printf("Result = %d%n", result);
		assertEquals( expectedResult, result);
	}
}