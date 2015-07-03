package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM146_YahtzeeScore;

@RunWith(Parameterized.class)
public class SRM146_YahtzeeScoreTest {
	private int[] toss;
	private int expectedResult;
	
	private static SRM146_YahtzeeScore yahtzeeScore = new SRM146_YahtzeeScore();

	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList( new Object [][] {
			{new int[] { 2, 2, 3, 5, 4 }, 5},
			{new int[] { 6, 4, 1, 1, 3 }, 6}, 
			{new int[] { 5, 3, 5, 3, 3 }, 10},
		} );
	}

	public SRM146_YahtzeeScoreTest(int[] toss, int expectedResult) {
		this.toss = toss;
		this.expectedResult = expectedResult;
	} 
	
	@Test
	public void YahtzeeScore() {
		int result;

		result = yahtzeeScore.maxPoints( toss ); 
		System.out.printf("Result = %d%n", result);
		assertEquals( expectedResult, result);
	}
}