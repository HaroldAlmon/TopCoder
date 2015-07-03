package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Div2_Level1.SRM632_RunningAroundPark;

@RunWith(Parameterized.class)
public class SRM632_RunningAroundParkTest {
	int totalTrees;
	int[] treeSequence;
	int result;
	
	private static SRM632_RunningAroundPark runningAroundPark = new SRM632_RunningAroundPark();

	@Parameters
	public static Collection< Object [] > data() {
		return Arrays.asList(
			new Object[][] {
				{ 3,  new int[] { 1, 2, 3 },                       1 },
				{ 24, new int[] { 6, 6 },                          2 },
				{ 3,  new int[] { 3, 2, 1 },                       3 },
				{ 50, new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 }, 2 }
			}
		);
	}
	
	public SRM632_RunningAroundParkTest( int totalTrees, int[] treeSequence, int result ) {
		this.result = result;
		this.treeSequence = treeSequence;
		this.totalTrees = totalTrees;
	}

	@Test
	public void RunningAroundPark(){
		assertEquals( result, runningAroundPark.numberOfLap( totalTrees, treeSequence ) );
	}
}
