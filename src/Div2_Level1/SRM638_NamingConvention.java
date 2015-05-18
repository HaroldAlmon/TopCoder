package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM638_NamingConvention {
	public String toCamelCase(String variableName) {
		StringBuffer result = new StringBuffer();
		char digit;
		for (int digitIndex = 0; digitIndex < variableName.length(); digitIndex++) {
			digit = variableName.charAt(digitIndex);
			
			if( digit == '_' ) {
				result.append( Character.toUpperCase(variableName.charAt(digitIndex+1)) );
				digitIndex += 1;
			} else
				result.append(digit);
		}
		System.out.printf("%s%n", result);
		return result.toString();
	}
	@Test
	public void test1() {
		assertTrue(toCamelCase("sum_of_two_numbers").equals("sumOfTwoNumbers"));
		assertTrue(toCamelCase("variable").equals("variable"));
		assertTrue(toCamelCase("variable").equals("variable"));
		assertTrue(toCamelCase("t_o_p_c_o_d_e_r").equals("tOPCODER"));
		assertTrue(toCamelCase("the_variable_name_can_be_very_long_like_this").equals("theVariableNameCanBeVeryLongLikeThis"));
		}
}
