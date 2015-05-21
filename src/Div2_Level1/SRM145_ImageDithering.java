package Div2_Level1;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class SRM145_ImageDithering {

	String dither = "BW";
	
	String[] screen = {
	"AAAAAAAA",
	 "ABWBWBWA",
	 "AWBWBWBA",
	 "ABWBWBWA",
	 "AWBWBWBA",
	 "AAAAAAAA"};

	public int count(String dither, String[] screen) {
		// Create dither counter and set to zero...
		int result = 0;
		
		char[] ditherArray = new char[dither.length()];
		
		// Split dither int char array.
		for(int i = 0; i < dither.length(); i += 1) {
			ditherArray[i] = dither.charAt(i);
		}
		for( String row : screen ) {
			for(char searchFor : ditherArray) {
				result += countDither(searchFor, row);
			}
		}
		return result;
	}
	
	int countDither(final char dither, String row) {
		int result = 0;
		int location = 0;

		while (true) {
			location = row.indexOf(dither, location);
			if (location != -1) {
				result += 1;
			}
			else {
				break;
			}
			location += 1;
		};

		return result;
	}

	@Test
	public void test1() {
		String dither = "BW";

		String[] screen = {
		"AAAAAAAA",
		 "ABWBWBWA",
		 "AWBWBWBA",
		 "ABWBWBWA",
		 "AWBWBWBA",
		 "AAAAAAAA"};
		assertTrue( unitTest(dither, screen) == 24 );
	}

	@Test
	public void test2() {
		String dither = "BW";

		String[] screen = {
		 "BBBBBBBB",
		 "BBWBWBWB",
		 "BWBWBWBB",
		 "BBWBWBWB",
		 "BWBWBWBB",
		 "BBBBBBBB"};

		assertTrue( unitTest(dither, screen) == 48 );
	}
	
	@Test
	public void test3() {
		String dither = "ACEGIKMOQSUWY";
		
		String[] screen = {
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};

		assertTrue( unitTest(dither, screen) == 150 );
	}
	
	@Test
	public void test4() {
		String dither = "DCBA";

		String[] screen = {
		 "ACBD" };

		assertTrue( unitTest(dither, screen) == 4 );
	}
	
	private int unitTest(String dither, String[] screen) {
		int result = count(dither, screen);
		System.out.println("Dither: " + dither);
		System.out.println("Screen: " + Arrays.toString(screen));
		System.out.println("Result: " + result + "\n");
		return result;
	}
}
