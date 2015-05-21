package Div2_Level1;

import org.junit.Test;

public class SRM633_Target {
	public String[] draw(int n) {
		int targetSize = n;
		String paperTarget[] = new String[ targetSize ];
		int centrePos = targetSize / 2 + 1;
		char[][] grid = new char[ targetSize ][ targetSize ];

		fillWithSpaces( grid, targetSize);
		drawDecreasingRectangles(targetSize, centrePos, grid);
		printTarget(targetSize, paperTarget, grid);
		
		return paperTarget;
	}

	private void printTarget(int targetSize, String[] paperTarget, char[][] grid) {
		StringBuilder line = new StringBuilder();

		for (int row = 0; row < targetSize; row++) {
			for (int column = 0; column < targetSize; column++)
				line.append( grid[ row ][ column ] );
			paperTarget[ row ] = line.toString();
			line.setLength( 0 );
			System.out.printf("%s%n", paperTarget[ row ]);
		}
	}

	private void drawDecreasingRectangles(int targetSize, int centrePos, char[][] grid) {
		int fillSize;

		for (int origin = 0; origin < centrePos; origin += 2) {
			fillSize = targetSize - 2 * origin;
			drawTopAndBottomLines(fillSize, grid, origin);
			drawLeftAndRightLines(fillSize, grid, origin);
		}
	}

	private void drawLeftAndRightLines(int fillSize, char[][] grid, int origin) {
		for (int row = origin + 1; row < origin + fillSize - 1; row++) {
			grid[ row ][ origin ] = '#';
			grid[ row ][ origin + fillSize - 1 ] = '#';
		}
	}

	private void drawTopAndBottomLines(int fillSize, char[][] grid, int origin) {
		for (int column = origin; column < origin + fillSize; column++) {
			grid[ origin ][ column ] = '#';
			grid[ origin + fillSize - 1 ][ column ] = '#';
		}
	}
	
	private void fillWithSpaces( char[][] target, int size ) {
		for( int row = 0; row < size ; row++) {
			for( int column = 0; column < size ; column++ ){
				target[ row ][ column ] = ' ';
			}
		}
	}

	@Test
	public void Target() {
		draw(5);
	}
}
