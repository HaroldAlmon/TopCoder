package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

// Passed TopCoder System Test on 5/24/2015
public class SRM146_RectangularGrid {
	public static void main(String[] args) {
		SRM146_RectangularGrid main = new SRM146_RectangularGrid();
		main.countRectangles(2,2);
	}

	public long countRectangles(int width, int height) {
		long result = 0;
		
		for(int row=0; row < height; row++) {
			for(int column = 0; column < width; column++) {
				int rows = height - row;
				int columns = width-column;

				// Number of rectangles = rows * columns
				// Number of squares = Math.min(rows, columns);
				int total = (rows) * (columns) - Math.min(rows, columns);
				result += total;
			}
		}
		return result;
	}

	@Test
	public void test1() {
		assertTrue(countRectangles(3, 3) == 22);
	}
	
	@Test
	public void test2() {
		assertTrue(countRectangles(5,2) == 31);
	}
	
	@Test
	public void test3() {
		assertTrue(countRectangles(10, 10) == 2640);
	}
	
	@Test
	public void test4() {
		assertTrue(countRectangles(1, 1) == 0);
	}
	
	@Test
	public void test5() {
		assertTrue(countRectangles(592, 964) == 81508708664L);
	}
}
