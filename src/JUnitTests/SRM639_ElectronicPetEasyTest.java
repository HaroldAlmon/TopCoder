package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM639_ElectronicPetEasy;

@RunWith(Parameterized.class)
public class SRM639_ElectronicPetEasyTest {
	private static SRM639_ElectronicPetEasy electronicPetEasy = new SRM639_ElectronicPetEasy();
	int st1;
	int p1;
	int t1;
	int st2;
	int p2;
	int t2;
	String result;

	public SRM639_ElectronicPetEasyTest(int [] input, String result) {
		this.st1 = input[0];
		this.p1 = input[1];
		this.t1 = input[2];
		this.st2 = input[3];
		this.p2 = input[4];
		this.t2 = input[5];
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 3, 3, 3, 5, 2, 3 }, "Difficult" },
				{ new int[] { 3, 3, 3, 5, 2, 2 }, "Easy" }
		});
	}
	
	@Test
	public void ElectronicPetEasyTest() {
		assertEquals( result, electronicPetEasy.isDifficult(st1, p1, t1, st2, p2, t2));
	}
	
	/*
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
	}*/
}
