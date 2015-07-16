package JUnitTests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SRM639_ElectronicPetEasyTest {

	public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
		return "Easy";
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 3, 3, 3, 5, 2, 3 }, "Difficult" }
		});
	}
	
	@Test(timeout = 500)
	public void test2() {
		assertTrue(isDifficult(3, 3, 3, 5, 2, 2) == "Easy");
	}

	@Test(timeout = 500)
	public void test3() {
		assertTrue(isDifficult(1, 4, 6, 1, 4, 7) == "Difficult");
	}
	
	@Test(timeout = 500)
	public void test4() {
		assertTrue(isDifficult(1, 1000, 1000, 2, 1000, 1000) == "Easy");
	}
	
	@Test(timeout = 500)
	public void test5() {
		assertTrue(isDifficult(1, 1, 1, 2, 2, 2) == "Easy");
	}
}
