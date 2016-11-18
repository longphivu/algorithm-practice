package other;

import java.util.LinkedList;
import java.util.List;

public class ReturnKnight {

	
	public static void solve(int n) {
		int[][] board = new int[n][n];
		int moves = n*n;
		int[] xMoves = {-2, -2, -1, +1, +2, +2, +1, -1};
		int[] yMoves = {-1, +1, +2, +2, +1, -1, -2, -2};
		LinkedList<Integer> moveList = new LinkedList<>();
		if (canMove(board, 0, 0, moves-1, moveList, xMoves, yMoves)) {
			print(moveList);
		} else {
			System.out.println("Solution does not exist");
		};
	}
	
	private static boolean canMove(int[][] board, int x, int y, int moves, LinkedList<Integer> moveList, int[] xMoves, int[] yMoves) {
		int n = board.length;
		int pos = x*n + y;
		//base case
		if (x < 0 || x >= board.length) return false;
		if (y < 0 || y >= board.length) return false;
		if (board[x][y] == 1) return false;
		
		if (moves == 0) {
			//finish all the board, print
			moveList.add(pos);
			return true;
		}
		
		for (int i = 0; i < xMoves.length; i++) {
			
			board[x][y] = 1;
			moveList.addLast(pos);
			if (canMove(board, x+xMoves[i], y+yMoves[i], moves-1, moveList, xMoves, yMoves)) {
				return true;
			} else {
				//backtrack
				board[x][y] = 0;
				moveList.removeLast();
			}
			
		}
		
		return false;
	}
	private static void print( List<Integer> moveList) {
		for (int pos : moveList) {
			System.out.print(pos + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		solve(7);

	}

}
