package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SRM650_TheKingsRoads {
	public String getAnswer(int h, int[] a, int[] b) {
		//int[] cities = new int[(int) (Math.pow(2,h))];
		// Allocate an extra city because the cities start at 1...
		// 2**h = 2 << (h-1)
		System.out.printf("\n");

		// cities[i] = the number of roads connected to city i...
		int[] cities = new int[2 << (h-1)];
		Set<String> edges = new HashSet<>();
		for (int skipRoad=0; skipRoad < cities.length; skipRoad++) {
			Arrays.fill(cities, 0);
			//System.out.printf("skipRoad = %d\n", skipRoad);
			for(int city=0; city < a.length; city++) {
				if(city != skipRoad) {
					int low, high;
					if(a[city] < b[city]) {
						low = a[city];
						high = b[city];
					} else {
						low = b[city];
						high = a[city];					
					}
					if ( edges.add( low + "+" + high) == false) {
						// Duplicate road is not valid...
						break;
					}
					// A loop back to the same 'city cannot be a valid start...
					if(a[city] == b[city]) {
						break;
					}
					cities[a[city]] += 1;
					cities[b[city]] += 1;
				}
			}
			if(isMapValid(cities, h) == true) {
				return "Correct";
			}
			edges.clear();
		}
		return "Incorrect";
	}
	
	private boolean isMapValid(int[] cities, int h) {
		// roadsPerCity[i] = the no. of cities with i roads.
		// One city may have 3 roads plus the King's = 4...
		int[] roadsPerCity = new int[4+1];
		for(int i=0; i < cities.length; i++) {
			try {
				roadsPerCity[cities[i]] += 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.printf("roadPerCity: %s\n", Arrays.toString(roadsPerCity));
		// 1 root (2 road) vertex
		if(roadsPerCity[2] != 1) 
			return false;

		// 2**(h-1)-2 middle (3 road) vertices. N.B. when using << need to use (h-2) not (h-1)
		if(roadsPerCity[3] != (( 2 << (h-2)) - 2 ))
			return false;
		
		// 2**(h-1) leaf (1 road) vertices.
		if(roadsPerCity[1] != (2 << (h-2) )) 
			return false;
		return true;
	}
	@Test
	public void testS41() {
		int[] a = {5, 7, 7, 1, 3, 6, 3};
		int[] b = {2, 5, 1, 7, 6, 4, 1};
		assertTrue( getAnswer(3, a, b) == "Incorrect");
	}
	
	@Test
	public void test1() {
		int[] a = {1, 2, 3, 7, 1, 5, 4};
		int[] b = {6, 7, 4, 3, 3, 1, 7};
		assertTrue( getAnswer(3, a, b) == "Correct");
	}
	
	@Test
	public void test2() {
		int[] a = {1, 2, 3};
		int[] b = {2, 1, 3};
		assertTrue( getAnswer(2, a, b) == "Incorrect");
	}
	
	
	@Test
	public void test3() {
		int[] a = {7, 1, 1, 2, 2, 3, 1};
		int[] b = {7, 1, 7, 4, 5, 2, 6};
		assertTrue( getAnswer(3, a, b) == "Incorrect");
	}
	
	@Test
	public void test4() {
		int[] a = {1, 3, 3};
		int[] b = {2, 1, 2};
		assertTrue( getAnswer(2, a, b) == "Correct");
	}

	@Test
	public void test5() {
		int[] a = {6, 5, 3, 3, 5, 5, 6};
		int[] b = {1, 5, 5, 6, 4, 7, 2};
		assertTrue( getAnswer(3, a, b) == "Correct");
	}
	
 

	@Test
	public void testS2() {
		int[] a = {20, 19, 17, 21, 12, 12, 31, 21, 8, 31, 8, 14, 5, 10, 18, 30, 18, 23, 14, 1, 17, 16, 19, 23, 16, 30, 1, 20, 5, 8, 10};
		int[] b = {2, 12, 10, 23, 24, 26, 4, 20, 13, 6, 29, 8, 30, 14, 27, 1, 13, 11, 31, 28, 5, 9, 18, 3, 22, 16, 7, 25, 21, 15, 19};
		assertTrue( getAnswer(5, a, b) == "Correct");
	}
	
	@Test
	public void testS3() {
		int[] a = {7, 1, 1, 2, 2, 3, 1};
		int[] b = {7, 1, 7, 4, 5, 2, 6};
		assertTrue( getAnswer(3, a, b) == "Incorrect");
	}
	

}


