package Div2_Level1;

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
}
