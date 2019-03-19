import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
	private String[][] board;

	public Board(){
		board = new String[6][7];
	}

	public void insertPiece(String piece, int x) {
		int y = findTopEmptyRow(x);
		setPiece(piece, x, y);
	}

	public boolean checkVictory(int mostRecentColumn) {
		boolean victory = false;
		int mostRecentRow;
		try {
			mostRecentRow = findTopEmptyRow(mostRecentColumn) - 1;
		}
		catch(Exception e){
			mostRecentRow = 5;
		}
		// Define possible paths
		boolean canLeft = true;
		boolean canUp = true;
		boolean canRight = true;
		boolean canDown = true;
		boolean canUpRight = true;
		boolean canUpLeft = true;
		boolean canDownRight = true;
		boolean canDownLeft = true;

		// Check possible paths
		if(mostRecentColumn < 3) {
			canDownLeft = false;
			canUpLeft = false;
			canLeft = false;
		}
		if(mostRecentColumn > 3) {
			canDownRight = false;
			canUpRight = false;
			canRight = false;
		}
		if(mostRecentRow < 3) {
			canDownLeft = false;
			canDownRight = false;
			canDown = false;
		}
		if(mostRecentRow > 2) {
			canUpRight = false;
			canUpLeft = false;
			canUp = false;
		}

		// Define paths
		int x = mostRecentColumn;
		int y = mostRecentRow;
		int[][] leftPath = new int[][]{{x,y}, {x-1,y}, {x-2,y}, {x-3,y}};
		int[][] upPath = new int[][]{{x,y}, {x,y+1}, {x,y+2}, {x,y+3}};
		int[][] rightPath = new int[][]{{x,y}, {x+1,y}, {x+2,y}, {x+3,y}};
		int[][] downPath = new int[][]{{x,y}, {x,y-1}, {x,y-2}, {x,y-3}};
		int[][] upRightPath = new int[][]{{x,y}, {x+1,y+1}, {x+2,y+2}, {x+3,y+3}};
		int[][] upLeftPath = new int[][]{{x,y}, {x-1,y+1}, {x-2,y+2}, {x-3,y+3}};
		int[][] downRightPath = new int[][]{{x,y}, {x+1,y-1}, {x+2,y-2}, {x+3,y-3}};
		int[][] downLeftPath = new int[][]{{x,y}, {x-1,y-1}, {x-2,y-2}, {x-3,y-3}};

		// Apply possible path tests
		if(canLeft && checkPathSame(leftPath)){
			victory = true;
		}
		if(canUp && checkPathSame(upPath)){
			victory = true;
		}
		if(canRight && checkPathSame(rightPath)){
			victory = true;
		}
		if(canDown && checkPathSame(downPath)){
			victory = true;
		}
		if(canUpRight && checkPathSame(upRightPath)){
			victory = true;
		}
		if(canUpLeft && checkPathSame(upLeftPath)){
			victory = true;
		}
		if(canDownRight && checkPathSame(downRightPath)){
			victory = true;
		}
		if(canDownLeft && checkPathSame(downLeftPath)){
			victory = true;
		}

		return victory;
	}

	public boolean checkEmptyTop(int x) {
		return board[5][x] == null;
	}

	public void printBoard() {
		for(int y = 5; y >= 0; y = y-1){
			String line = "| ";
			for(int x = 0; x < 6; x++) {
				if(this.board[y][x] == null) {
					line = line + "  | ";
				}
				else {
					line = line + this.board[y][x] + " | ";
				}
			}
			if(this.board[y][6] == null) {
				line = line + "  |";
			}
			else {
				line = line + this.board[y][6] + " |";
			}
			System.out.println(line);
		}
		System.out.println("  1   2   3   4   5   6   7   ");
	}

	private void setPiece(String piece, int x, int y){
		board[y][x] = piece;
	}

	private int findTopEmptyRow(int x) {
		int topEmpty = 0;
		for(int y = 0; y < 6; y++) {
			if(board[y][x] != null) {
				if(y != 5) {
					topEmpty = y + 1;
				}
				else {
					throw new IndexOutOfBoundsException("No empty rows at column " + Integer.toString(x));
				}
			}
			else {
				return topEmpty;
			}
		}
		return 0;
	}

	private boolean checkPathSame(int[][] path) {
		String symbol = board[path[0][1]][path[0][0]];
		boolean same = true;
		for(int i = 0; i < path.length; i++){
			if(symbol != board[path[i][1]][path[i][0]]){
				same = false;
			}
		}
		return same;
	}
}
