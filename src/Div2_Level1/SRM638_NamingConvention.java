package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SRM638_NamingConvention {
	public String toCamelCase(String variableName) {
		StringBuffer result = new StringBuffer();
		char c;
		for (int i = 0; i < variableName.length(); i++) {
			c = variableName.charAt(i);
			if( c == '_' ) {
				result.append( Character.toUpperCase(variableName.charAt(i+1)) );
				i++;
			} else
				result.append(c);
		}
		System.out.printf("%s", result);
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
