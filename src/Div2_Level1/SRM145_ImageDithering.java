package Div2_Level1;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class SRM145_ImageDithering {
	public int count(String dither, String[] screen) {
		int ditherCount = 0;
		
		char[] ditherArray = new char[dither.length()];

		ditherArray = dither.toCharArray();

		for( String row : screen ) {
			for(char searchFor : ditherArray) {
				ditherCount += countDither(searchFor, row);
			}
		}
		return ditherCount;
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
}
