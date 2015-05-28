package Div2_Level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
//===== DO NOT COPY ^^^^ ==================================

public class SRM651_RobotOnMoonEasy {
	public String isSafeCommand(String[] board, String S) {
		String result = "Alive";
		int strPos = 0;
		int row = 0;
		
		// Find the robot...
		for (int i = 0; i < board.length; i++) {
			if (board[i].indexOf('S') >= 0) {
				strPos = board[i].indexOf('S');
				row = i;
			}
			//System.out.printf("array = %s\n", board[i]);
		}
		//System.out.printf("start (%d, %d)\n", strPos, row);

		// Move the Robot...
		for (int i = 0; i < S.length(); i++) {
			switch (S.charAt(i)) {
			case 'U':
				if (row == 0 || board[row - 1].charAt(strPos) != '#')
					row--;
				break;

			case 'D':
				if ((row == board.length - 1) || (board[row + 1].charAt(strPos) != '#'))
					row++;
				break;

			case 'L':
				if (strPos == 0 || board[row].charAt(strPos - 1) != '#')
					strPos--;
				break;

			case 'R':
				if ((strPos == board[0].length() - 1) || (board[row].charAt(strPos + 1) != '#'))
					strPos++;
			}

			// Check if stPos or row goes off the board...
			if (strPos < 0 || strPos >= board[0].length() || row < 0
					|| row >= board[0].length())
				return "Dead";

			// System.out.printf("cmd = %s, position (%d, %d)\n", S.charAt(i),
			// strPos, row);
		}
		
		//System.out.printf(" Result = %s\n", result);
		return result;
		
	}
	
	// DO NOT COPY ==== vvvvv =====
	@Test
	public void test0() {
		String[] board = 		
			    {".....",
				 ".###.",
				 "..S#.",
				 "...#."};
		String S = "URURURURUR";
		
		String result = isSafeCommand(board, S);
		//System.out.println("result = " + result);
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
		//System.out.println("result = " + result);
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
		//System.out.println("result = " + result);
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
		//System.out.println("result = " + result);
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
		//System.out.println("result = " + result);
		assertTrue( result == "Dead") ;
	}
	

	@Test
	public void test5() {
		String[] board =  
				{"S"};
		String S = "R";
		String result = isSafeCommand(board, S);
		//System.out.println("result = " + result);
		assertTrue( result == "Dead") ;
	}	
}