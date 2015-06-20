package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM146_RectangularGrid;

@RunWith(Parameterized.class)
public class SRM146_RectangularGridTest {
	private int width;
	private int height;
	private long expectedResult;
	private static SRM146_RectangularGrid rectangularGrid = new SRM146_RectangularGrid();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{3,   3,   22L},
			{5,   2,   31L}, 
			{10,  10,  2640L},
			{1,   1,   0L},
			{592, 964, 81508708664L}
		} );
	}

	public SRM146_RectangularGridTest(int width, int height, long expectedResult) {
		this.width = width;
		this.height = height;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void RectangualarGrid() {
		long result;

		result = rectangularGrid.countRectangles(width, height); 
		System.out.printf("Result = %d%n", result);
		assertEquals( expectedResult, result);
	}
}