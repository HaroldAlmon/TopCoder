package JUnitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import Div2_Level1.SRM645_BacteriesColony;

@RunWith(Parameterized.class)
public class SRM645_BacteriesColonyTest {
	private SRM645_BacteriesColony bacteriesColony = new SRM645_BacteriesColony();
	int[] before;
	int[] after;

@Parameters
public static Collection<Object []> data() {
	Object [][] data = {
		{ new int[] { 5, 3, 4, 6, 1 },          new int[] { 5, 4, 4, 4, 1 } },
		{ new int[] { 1, 5, 4, 9 },             new int[] { 1, 4, 5, 9 } },
		{ new int[] { 78, 34, 3, 54, 44, 99 },	new int[] { 78, 34, 34, 49, 49, 99 } },
		{ new int[] { 78, 34, 3, 54, 44, 99 },  new int[] { 78, 34, 34, 49, 49, 99 } }
	};
	return Arrays.asList(data);
}
	
	public SRM645_BacteriesColonyTest(int [] before, int[] after) {
		this.before = before;
		this.after = after;
	}
	
	@Test
	public void bacteriesColonyTest() {
		int[] before = this.before;
		int[] after = this.after;
		assertTrue(Arrays.equals( bacteriesColony.performTheExperiment(before), after) );
	}
}
