package Div2_Level1;

import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SRM648_Fragile {
	public int countPairs(String[] graph) {
		int startCount;
		startCount = getCount(graph);
		int artCount = 0;
		int pairCount = 0;
		String[] copyGraph;
		for(int i=0; i< graph.length; i++) {
			for (int j=i+1; j < graph.length; j++) {
				copyGraph = deleteVertices(graph, i, j);
				artCount = getCount(copyGraph);
				if(artCount -2 > startCount) {
					pairCount += 1;
				}
			}
		}
		return pairCount;
	}
	private int getCount(String[] graph) {
		Set<Integer> visited = new HashSet<Integer>();
		Set<Integer> GraphComponents = new HashSet<>();
		
		for (int i=0; i < graph.length; i++) {
			if (visited.add(i) == true) {
				GraphComponents.add(i);
				visited.add(i);
				
				for (int j=0; j < graph.length; j++) {
					if(graph[i].charAt(j) == 'Y') {
						traverse(graph, visited, j);
					};
				}
			}
		}
		return GraphComponents.size();
	}
	private void traverse(String[] graph, Set<Integer> visited, int vertex ) {
		if (visited.add(vertex) == false) {
			return;
		}
		for (int i=0; i < graph.length; i++) {
			if(graph[vertex].charAt(i) == 'Y') {
				traverse(graph, visited, i);
			};
		}
	}
	private String[] deleteVertices(String[] graph, int v1, int v2) {
		int vertexCount = graph.length;
		String[] result = new String[vertexCount];
		for(int vertex = 0; vertex < vertexCount; vertex++) {
			if (vertex != v1 && vertex != v2) {
				boolean reset = false;
				result[vertex] = new String(graph[vertex]);
				for(int i = 0; i < vertexCount; i++) {
					if (i == v1 || i == v2) {
						if (result[vertex].charAt(i) == 'Y') {
							result[vertex] = result[vertex].substring(0, i) + "N" + result[vertex].substring(i+1);
							reset = true;
						}
					}
				}
				if (reset == false) {
					result[vertex] = new String(graph[vertex]);
				}
			} else {
				result[vertex] = graph[vertex].replaceAll("Y", "N");
			}
		}
		return result;
	}

	@Test
	public void test1() {
		String[] graph = {"NYNN", "YNYN", "NYNY", "NNYN"};
		assertTrue(countPairs(graph) == 3);
	}
	
	@Test
	public void test2() {
		String[] graph = {"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"};
		assertTrue(countPairs(graph) == 5);
	}
	
	@Test
	public void test3() {
		String[] graph = {"NNN", "NNN", "NNN"};
		assertTrue(countPairs(graph) == 0);
	}
	
	@Test
	public void test4() {
		String[] graph = {
				"NYNYNNYYNN", // 0
				"YNNNYNYYNN", // 1
				"NNNNYNNNYN", // 2
				"YNNNYYNNNN", // 3
				"NYYYNNNNYN", // 4
				"NNNYNNNNYN", // 5
				"YYNNNNNNNN", // 6
				"YYNNNNNNYN", // 7
				"NNYNYYNYNY", // 8
				"NNNNNNNNYN"}; //9
		assertTrue(countPairs(graph) == 9);
	}
	
	@Test
	public void test5() {
		String[] graph =  

	{"NNNYNNYNNNNNNNYYNNNY", "NNNNNNNNYNNNNNNNNNNN", "NNNNNNNNNNNNNNNNNNNN", "YNNNNNNNNNYNNNNNNNNN", "NNNNNNNYNNNNNYNNNNYN",
	 "NNNNNNNNNNNNNNNNYNNY", "YNNNNNNNNNNNNYYYNYNN", "NNNNYNNNNNNNNYYNNNNN", "NYNNNNNNNYNNNNNNNNNN", "NNNNNNNNYNNNYNNNNNYN",
	 "NNNYNNNNNNNNNNYNNNNN", "NNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNNYNN", "NNNNYNYYNNNNNNNNNNNN", "YNNNNNYYNNYNNNNNNNNN",
	 "YNNNNNYNNNNNNNNNYNNN", "NNNNNYNNNNNNNNNYNYNN", "NNNNNNYNNNNNYNNNYNNN", "NNNNYNNNNYNNNNNNNNNN", "YNNNNYNNNNNNNNNNNNNN"};
		assertTrue(countPairs(graph) == 42);
	}
	
	//@Before
	public void header() {
		System.out.println("===================================");
	}
}

