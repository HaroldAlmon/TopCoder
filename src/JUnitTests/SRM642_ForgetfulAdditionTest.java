package JUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM642_ForgetfulAddition;

@RunWith(Parameterized.class)
public class SRM642_ForgetfulAdditionTest {
	private int expectedResult;
	private String expression;
	
	private static SRM642_ForgetfulAddition forgetfulAddition = new SRM642_ForgetfulAddition();

	@Parameters
	public static Collection< Object [] > getData() {
		return Arrays.asList(new Object[][] {
			{ "22",			4},
			{ "123",		15},
			{ "1289",		101},
			{ "31415926",	9067}
		});
	}
	
	public SRM642_ForgetfulAdditionTest( String input, int expectedResult ) {
		this.expression = input;
		this.expectedResult = expectedResult;
	}

	@Test( timeout = 500)
	public void ForgetfulAdditionTest() {
		assertEquals( forgetfulAddition.minNumber( expression ), expectedResult );
	}
}


