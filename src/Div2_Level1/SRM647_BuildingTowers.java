package Div2_Level1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// From TopCoder.com,   SRM 647 

// Solution strategy. Iterate backwards from the last build
// and change the previous building size so that we can 
// get too the current building.
//
// Iterate forwards from the first building.
// If the limit is too high, go as high as possible,
// else determine number of steps needed to reach the
// building height.  Calculate the remaining steps
// build up and back down to the next building.
// After reaching the last building calculate
// the number of steps remaining and build
// as high as possible.
public class SRM647_BuildingTowers {
		long maxHeight(int N, int K, int[] x, int[] t) {
		long currHeight = 0;
		long currPos = 1;
		long max = 0;

		//System.out.printf( "x[] = %s\n", Arrays.toString(x) );
		//System.out.printf( "t[] = %s\n", Arrays.toString(t) );
		chopBuildings(x, t, K);
		//System.out.printf( "t[] = %s\n\n", Arrays.toString(t) );

		for(int i=0; i < x.length; i++) {
			//System.out.printf("(%d, %d)\n", x[i], t[i]);
		
			// How high to go to the next level...
			long rise = t[i] - currHeight;
			long maxPossible = (x[i] - currPos) * K;

			// Need the rise % K to handle 8/3 = 2, should be 3, (8 + (3-8%3)) / 3 = (8+(3-2)) / 3 = (8+1) / 3 = 9/3 = 3
			currPos = currPos + ((Math.abs(rise) + (K-(rise % K))) / K);
			
			if(currPos > x[i]) {
				// If we overshoot the last building reset the current position...
				currPos = x[i];
			}

			if (maxPossible < t[i]) {
				// Can't reach the next building so go up as much as possible...
				currHeight += maxPossible;
			}
			else {
				// We can still go up and then back down to the next building...
				// steps to next building = (x[i] - currPos)
				max = Math.max(max, currHeight + ((x[i] - currPos)/2) * K);
				currPos = x[i];
				currHeight = t[i];
			}
			
			// Check for new max height...
			if (currHeight > max) {
				max = currHeight;
			}
			//System.out.printf("Position = (%d, %d) max = %d\n", currPos, currHeight, max);
		}
		//System.out.println("Final = " + (N - currPos) * K);
		
		long endHeight = currHeight + (N - currPos) * K;
		if (endHeight > max) {
			max = endHeight;
		}
		return max;
	};
	
	// Make sure that when we get to the last building we can still
	// reach the ground.  If this not is possible, reduce the height
	// of the previous buiding(s).
	// Note the typecast to long on K, so the calculation does not overflow...
	private void chopBuildings(int[] x, int []t, int K) {
		long maxHeight = 0;
		for(int i = t.length - 1; i > 0; i--){
			maxHeight = t[i] + ((x[i] - x[i-1]) * (long) K);
			if( maxHeight < t[i-1] ) {
				t[i-1] = (int) maxHeight;
			}
		}
	}
	
	@Test
	public void test1() {
		int[] x = {3,8};
		int[] t = {1,1};
		
		long result = maxHeight(10, 1, x, t);
		System.out.printf("max(10,1) = %d%n", result);
		assertTrue( result == 3);
	}
	
	@Test
		public void test2() {
		int[] x = {4,7,13,15,18};
		int[] t = {8,22,1,55,42};
		
		long result = maxHeight(20, 3, x, t);
		System.out.printf("max(20,3) = %d%n", result);
		assertTrue( result == 22);
	}
	
	@Test
	public void test3() {
	int[] x = {34,35,48,86,110,170,275,288,313,321,344,373,390,410,412,441,499,525,538,568,585,627,630,671,692,699,719,752,755,764,772};
	int[] t = {89,81,88,42,55,92,19,91,71,42,72,18,86,89,88,75,29,98,63,74,45,11,68,34,94,20,69,33,50,69,54};
	
	long result = maxHeight(780, 547990606, x, t);
	System.out.printf("max(780,547990606) = %d%n", result);
	//28,495,511,604
	assertTrue( result == 28495511604L);
	}
	
	@Test
	public void test4() {
	int[] x = {};
	int[] t = {};
	
	long result = maxHeight(1000000000, 1000000000, x, t);
	System.out.printf("max(1000000000, 1000000000) = %d\n", result);

	assertTrue( result == 999999999000000000L);
	}

	@Test
	public void test5() {
	int[] x = {134668,488112,558756,590300,787884,868112,1550116,1681439,1790994,
			1796091,1906637,2005485,2152813,2171716,2255697,2332732,2516853,
			2749024,2922558,2930163,3568190,3882735,4264888,5080550,5167938,
			5249191,5574341,5866912,5936121,6142348,6164177,6176113,6434368,
			6552905,6588059,6628843,6744163,6760794,6982172,7080464,7175493,
			7249044};
	int[] t = {8,9,171315129,52304509,1090062,476157338,245,6,253638067,37,500,
			29060,106246500,129,22402,939993108,7375,2365707,40098,10200444,
			3193547,55597,24920935,905027,1374,12396141,525886,41,33,3692,
			11502,180,3186,5560,778988,42449532,269666,10982579,48,3994,1,9};
	
	long result = maxHeight(7824078, 2374, x, t);
	System.out.printf("max(7824078, 2374) = %d%n", result);

	assertEquals( 1365130725, result);
	}
}

