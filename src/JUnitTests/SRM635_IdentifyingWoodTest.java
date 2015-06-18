package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM635_IdentifyingWood;

@RunWith(Parameterized.class)
public class SRM635_IdentifyingWoodTest {
	private String sourceDigits;
	private String targetDigits;
	private String expectedResult;
	private static SRM635_IdentifyingWood identifyingWood = new SRM635_IdentifyingWood();
	private static final String YES = "Yep, it's wood";
	private static final String NO = "Nope";
	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{"string",   "longstring", NO},
			{"oxoxoxox", "ooxxoo",     NO}, 
			{"oxoxoxox", "xxx",        YES},
			{"qwerty",   "qwerty",     YES},
			{"string",   "longstring", NO}
		} );
	}

	public SRM635_IdentifyingWoodTest(String sourceDigits, String targetDigits, String expectedResult) {
		this.sourceDigits = sourceDigits;
		this.targetDigits = targetDigits;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void RectangualarGrid() {
		String result;

		result = identifyingWood.check(sourceDigits, targetDigits); 
		System.out.printf("Result = %s%n", result);
		assertEquals( expectedResult, result);
	}
}