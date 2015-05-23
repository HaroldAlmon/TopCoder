package JUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM145_ImageDithering;

@RunWith(Parameterized.class)
public class SRM145_ParamTests {
	private String dither;
	private String[] screen;
	private int expectedResult;
	private static SRM145_ImageDithering  srm145_ImageDithering  = new SRM145_ImageDithering ();


	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
		{
			"BW",
			new String[] {
				"AAAAAAAA",
				"ABWBWBWA",
				"AWBWBWBA",
				"ABWBWBWA",
				"AWBWBWBA",
				"AAAAAAAA"}, 
			24 
		},
		
		{
			"BW",
			new String[] {
				"BBBBBBBB",
				"BBWBWBWB",
				"BWBWBWBB",
				"BBWBWBWB",
				"BWBWBWBB",
				"BBBBBBBB"}, 
			48 
		},
		
		{
			"ACEGIKMOQSUWY",
			new String[] {
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"},
			150
		},
		
		{
			"DCBA",
			new String[] {
			 "ACBD" },
			 4
		}

		});
	}
		
	public SRM145_ParamTests(String dither, String[] screen, int expectedResult) {
		this.dither = dither;
		this.screen = screen;
		this.expectedResult = expectedResult;
	}
	
	@Test(timeout = 500)
	public void srm145_ImageDithering() {
		int result;

		result = srm145_ImageDithering.count(dither, screen);
		System.out.println("Dither: " + dither);
		System.out.println("Screen: " + Arrays.toString(screen));
		System.out.println("Result: " + result + "\n");
		assertEquals( expectedResult, result);
	}
}