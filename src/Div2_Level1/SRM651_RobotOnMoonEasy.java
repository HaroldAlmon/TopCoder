package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class SRM651_RobotOnMoonEasy {
	public String isSafeCommand(String[] board, String S) {
		String robotHealth;
		int digitIdx = 0;
		int row = 0;
		
		// Find the robot...
		for (int i = 0; i < board.length; i++) {
			if (board[i].indexOf('S') >= 0) {
				digitIdx = board[i].indexOf('S');
				row = i;
				break;
			}
		}

		robotHealth = moveRobot(board, S, digitIdx, row);
		
		//System.out.printf(" Result = %s%d", result);
		return robotHealth;
		
	}

	private String moveRobot(String[] board, String S, int digitIdx, int row) {
		// Move the Robot...
		for (int i = 0; i < S.length(); i++) {
			switch (S.charAt(i)) {
			case 'U':
				if (row == 0 || board[row - 1].charAt(digitIdx) != '#')
					row--;
				break;

			case 'D':
				if ((row == board.length - 1) || (board[row + 1].charAt(digitIdx) != '#'))
					row++;
				break;

			case 'L':
				if (digitIdx == 0 || board[row].charAt(digitIdx - 1) != '#')
					digitIdx--;
				break;

			case 'R':
				if ((digitIdx == board[0].length() - 1) || (board[row].charAt(digitIdx + 1) != '#'))
					digitIdx++;
			}

			// Check if stPos or row goes off the board...
			if (digitIdx < 0 || digitIdx >= board[0].length() || row < 0
					|| row >= board[0].length())
				return "Dead";
		}
		return "Alive";
	}
	
	@Test
	public void test0() {
		String[] board = 		
			    {".....",
				 ".###.",
				 "..S#.",
				 "...#."};
		String S = "URURURURUR";
		
		String result = isSafeCommand(board, S);
		assertTrue( result == "Alive") ;
	}
	
	@Test
	public void test1() {
		String[] board = 		
			{".....",
				 ".###.",
				 "..S..",
				 "...#."};
		String S = "URURURURUR";
		
		String result = isSafeCommand(board, S);
		assertTrue( result == "Dead") ;
	}
	
	@Test
	public void test2() {
		String[] board = 		
			{".....",
			 ".###.",
			 "..S..",
			 "...#."};
		String S = "URURU";
		
		String result = isSafeCommand(board, S);
		assertTrue( result == "Alive") ;
	}


	@Test
	public void test3() {
		String[] board = { 
				"#####", 
				"#...#", 
				"#.S.#",
				"#...#", 
				"#####" };
		String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
		String result = isSafeCommand(board, S);
		assertTrue( result == "Alive") ;
	}
	
	@Test
	public void test4() {
		String[] board = {
				 "#####",
				 "#...#",
				 "#.S.#",
				 "#...#",
				 "#.###"};
		String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
		String result = isSafeCommand(board, S);
		assertTrue( result == "Dead") ;
	}
	

	@Test
	public void test5() {
		String[] board =  
				{"S"};
		String S = "R";
		String result = isSafeCommand(board, S);
		assertTrue( result == "Dead") ;
	}	
}