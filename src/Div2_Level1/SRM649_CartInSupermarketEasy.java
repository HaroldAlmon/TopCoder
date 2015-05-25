package Div2_Level1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SRM649_CartInSupermarketEasy {
	private int splits = 0;
	private int turns = 0;
	public int calc(int N, int K) {
		List<Integer> cartline = new ArrayList<Integer>();
		cartline.add(N);
		splits = K;
		split(cartline);
		return turns;
	}
	
	private void split(List<Integer> cartline) {
		boolean split;
		split = false;
		turns += 1;
		Collections.sort(cartline);
		Collections.reverse(cartline);
		System.out.printf("Cartline %s, Splits = %d\n", Arrays.toString(cartline.toArray()), splits);
		Iterator<Integer> iter = cartline.iterator();
		List<Integer> splitCartline = new ArrayList<Integer>();
		if (splits > cartline.size() ) {
			while (iter.hasNext()) {
				int count1 = iter.next();
				if (splits > 0) {
					int count2 = 0;
					if (count1 != 1) {
						count2 = (count1 >> 1) + (count1 % 2);
						count1 >>= 1;
						//System.out.printf("Split (%d) into (%d), (%d)\n", count1
								//+ count2, count1, count2);
						splitCartline.add(count1);
						splitCartline.add(count2);
						splits--;
						split = true;
					} else {
						if (!splitCartline.contains(1)) {
							splitCartline.add(count1);
						}
					}
				} else {
					if (!splitCartline.contains(1)) {
						splitCartline.add(count1);
					}				
				}
				// If nothing could be split, the cartline must be all 1's, so clear the cartline...
				if(split == false) {
					splitCartline.clear();
				}
			} 
		} else {
			// Not doing a split, decrement cart count...
			while (iter.hasNext()) {
				int item = iter.next();
				if(item != 1) {
					splitCartline.add(item - 1);
				}
			}
		}
		System.out.printf("Split Cartline %s\n", Arrays.toString(splitCartline.toArray()));
		System.out.printf("Turns %d, Splits left %d\n\n", turns, splits);
		if (splitCartline.size() > 0) {
			split(splitCartline);
		} else return;
	}
	@Test
	public void test6() {
		assertTrue(calc(100,100) == 8);
	}
	
	@Test
	public void test1() {
		assertTrue(calc(5,0) == 5);
	}
	
	@Test
	public void test2() {
		assertTrue(calc(5,2) == 4);
	}
	
	@Test
	public void test3() {
		assertTrue(calc(15,4) == 6);
	}
	
	@Test
	public void test4() {
		assertTrue(calc(7,100) == 4);
	}
	
	@Test
	public void test5() {
		assertTrue(calc(45,5) == 14);
	}
	
	@Before
	public void before() {
		System.out.println("--- Running Test ----");
	}
}
