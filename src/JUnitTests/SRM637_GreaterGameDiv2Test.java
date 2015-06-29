package JUnitTests;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM637_GreaterGameDiv2;

@RunWith(Parameterized.class)
public class SRM637_GreaterGameDiv2Test {
	int cardListSnuke[];
	int cardListSothe[];
	int result;
	
	private static SRM637_GreaterGameDiv2 greaterGameDiv2 = new SRM637_GreaterGameDiv2();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object[][] {
			{ new int[] {1,3}, 			new int[] {4, 2},		1},
			{ new int[] {1,3,5,7,9},	new int[] {2,4,6,8,10}, 0},
			{ new int[] {2},			new int[] {1},			1},
			{ new int[] {1,3,5,7,9},	new int[] {2,4,6,8,10},	0},
			{ new int[] {2},			new int[] {1},			1},
			{ new int[] {3,5,9,16,14,20,15,17,13,2}, 
										new int[] {6,18,1,8,7,10,11,19,12,4}, 
																6}
		});
	}
	
	public SRM637_GreaterGameDiv2Test(int [] cardListSnuke, int [] cardListSothe, int result) {
		this.cardListSnuke = cardListSnuke;
		this.cardListSothe = cardListSothe;
		this.result = result;
	}

	@Test
	public void greaterGameDiv2Test() {
		assertEquals(result, greaterGameDiv2.calc(cardListSnuke, cardListSothe ));
	}
}
