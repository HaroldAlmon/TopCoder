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
}
