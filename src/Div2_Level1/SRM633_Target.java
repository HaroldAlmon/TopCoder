package Div2_Level1;

import java.util.Arrays;

import org.junit.Test;

public class SRM633_Target {
	public String[] draw(int n) {
		String result[] = new String[n];
		int size = n/2 + 1;
		char[][] grid = new char[n][n];
		int fillSize;
		for (int i = 0; i < size; i+=2) {
			fillSize = n-2*i;
			for (int j = i; j < i+fillSize; j++) {
				grid[i][j] = '#';
				grid[i+fillSize-1][j] = '#';
			}
			for (int row = i+1; row < i+fillSize-1; row++) {
				grid[row][i] = '#';
				grid[row][i+fillSize-1] = '#';
			}
		}
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				line.append( grid[i][j] );
			result[i] = line.toString();
			line.setLength(0);
			System.out.printf("%s\n", result[i]);
		}
		
		return result;
	}
	@Test
	public void test1() {
		//draw(5);
		draw(21);
	}
}
