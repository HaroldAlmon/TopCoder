package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class SRM646_TheGridDivTwo {
	int max = 0;
	public int find(int[] x, int[] y, int k) {
		int result = Math.max(0, search(0, 0, x, y, k));
		System.out.printf("Result = %d%d", result);
		return result;
	}
	
	public int search(int px, int py, int[] x, int[] y, int k) {
		System.out.printf("search(%d, %d)%n", px, py);
		if (k == 0) 
			return px;
		//int result = moveUp(px, py, x, y, k);
		int result = Math.max( moveUp(px, py, x, y, k), moveDown(px, py, x, y, k) );
		System.out.printf("search result returns %d%n", result);
		return result;
	}
	
	private int moveUp(int px, int py, int[] x, int[] y, int k) {
		// Can we go right?
		int max = px;
		boolean block = false;
		for (int i = 0; i < y.length; i++) {
			System.out.printf("Check (%d,%d)%n", x[i], y[i]);
			if (y[i] == py && x[i] == px + 1) {
				// found a blocking point...
				System.out.printf("Blocked by (%d,%d)%n", x[i], y[i]);
				block = true;
				break;
			}
		}
		if (block == false) {
			moveTo(px + 1, py, x, y, k);
			max =  moveUp(px + 1, py, x, y, k);
		}
		
		// Can we go up?
		boolean blockup = false;
		for (int i = 0; i < y.length; i++) {
			System.out.printf("Check (%d,%d)%n", x[i], y[i]);
			if (x[i] == px && y[i] == py + 1) {

				// found a blocking point...
				System.out.printf("Blocked by (%d,%d)%n", x[i], y[i]);
				blockup = true;
				break;
			}
		}
		if (blockup == false) {
			moveTo(px, py + 1, x, y, k);
			max = Math.max( max, moveUp(px, py + 1, x, y, k));
		}
		
		// if move left
		//		return moveLeft()
		// end if
		return max;
	}
	
	private int moveDown(int px, int py, int[] x, int[] y, int k ) {
		// if move right 
		//		return moveRight()
		// end if
		
		// if move down
		//		add(px, py) to blocked(cx,cy)
		// 		py--
		//		k--
		//		return Math.max(search(px, py, cx, cy, k), max);
		// end if 
		
		// if move left
		//		return moveLeft()
		// end if
		return max;
	}
	
	private int moveRig4444ht(int px, int py, int[] x, int[] y, int k ) {
		int[] cx = Arrays.copyOf(x, x.length + 1);
		int[] cy = Arrays.copyOf(y, y.length + 1);
		
		cx[cx.length-1] = px;
		cy[cy.length-1] = py;
		
		// Move to the right...
		px++;
		k--;
		return search(px, py, x, y, k);
	}
	
	private void moveTo(int px, int py, int[] x, int[] y, int k ) {
		// Add blocking point...
		int[] cx = Arrays.copyOf(x, x.length + 1);
		int[] cy = Arrays.copyOf(y, y.length + 1);
		
		cx[cx.length-1] = px;
		cy[cy.length-1] = py;
		
		k--;
		//return search(px, py, x, y, k);
	}

	@Test
	public void test1() {
		int[] a = {1,1,1,1};
		int[] b = {-2,-1,0,1};
		assertTrue( find(a,b,4) == 2 );
	}

	@Test
	public void test2() {
		int[] a = {-1, 0, 0, 1};
		int[] b = {0, -1, 1, 0};
		assertTrue( find(a,b,9) == 0 );
	}
	
	@Test
	public void test3() {
		int[] a = {};
		int[] b = {};
		assertTrue( find(a,b,1000) == 1000 );
	}

	//@Test
	public void test4() {
		int[] a = {1,0,0,-1,-1,-2,-2,-3,-3,-4,-4};
		int[] b = {0,-1,1,-2,2,-3,3,-4,4,-5,5};
		assertTrue( find(a,b,47) == 31 );
	}
	 
	@Before
	public void before() {
		System.out.println("-----------------------------");
	}
}


