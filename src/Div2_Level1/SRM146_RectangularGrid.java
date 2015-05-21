package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/* SRM-5 300 points
Problem Statement:  
Given the width and height of a rectangular grid, return the total 
number of rectangles (NOT counting squares) that can be found on this grid.
For example, width = 3, height = 3 (see diagram below):
 __ __ __
|__|__|__|
|__|__|__|
|__|__|__|
In this grid, there are 4 2x3 rectangles, 6 1x3 rectangles and 12 1x2 rectangles. 
Thus there is a total of 4 + 6 + 12 = 22 rectangles. 
Note we don't count 1x1, 2x2 and 3x3 rectangles because they are squares.  */
public class SRM146_RectangularGrid {
	public static void main(String[] args) {
		SRM146_RectangularGrid main = new SRM146_RectangularGrid();
		main.countRectangles(2,2);
	}

	/* Strategy: Starting at the top left, loop through every square in the
	 * rectangle.  For Each square count all of the rectangles to the bottom right and
	 * subtract the number of squares.
	 * The rectangles are just the number of rows * columns at the bottom right minus the
	 * number of squares.
	 * The number of squares is the minimum of rows and columns at the bottom right.
	 */
	public long countRectangles(int width, int height) {
		long result = 0;
		
		for(int i=0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				int rows = height - i;
				int columns = width-j;
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
