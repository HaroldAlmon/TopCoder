package Div2_Level1;

public class SRM642_ForgetfulAddition {
	public int minNumber( String expression ) {
		int minimumSum = Integer.MAX_VALUE;
		
		for ( int digitIndex = 1; digitIndex < expression.length(); digitIndex++ ) {
			int int1;
			int int2;
			int total; 
			
			int1 = Integer.parseInt( expression.substring( 0, digitIndex) );
			int2 = Integer.parseInt( expression.substring( digitIndex, expression.length() ) );

			total = int1 + int2;
			
			if ( total < minimumSum )
				minimumSum = total;
		}

		return minimumSum;
	}
}


