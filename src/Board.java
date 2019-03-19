public class Board {
	private String[][] board;
	
	public Board(){
		board = new String[6][7];
	}

	public void setPiece(String piece, int x, int y){

	}

	public static void insertPiece(String piece, int x) {


	}

	public static boolean checkVictory() {
		return false;
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
	}
}
