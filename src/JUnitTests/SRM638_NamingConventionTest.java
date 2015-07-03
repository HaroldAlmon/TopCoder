package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM638_NamingConvention;
@RunWith(Parameterized.class)

public class SRM638_NamingConventionTest {
	String input;
	String result;
	private static SRM638_NamingConvention namingConvention = new SRM638_NamingConvention();
	
	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object[][] {
			{"sum_of_two_numbers",	"sumOfTwoNumbers"},
			{"sum_of_two_numbers",	"sumOfTwoNumbers"},
			{"t_o_p_c_o_d_e_r",		"tOPCODER"},
			{"the_variable_name_can_be_very_long_like_this", "theVariableNameCanBeVeryLongLikeThis"}
		});
	}
	
	public SRM638_NamingConventionTest(String input, String result) {
		this.input = input;
		this.result = result;
	}

	@Test
	public void namingConventionTest() {
		assertEquals( result, namingConvention.toCamelCase(input));
	}
}
