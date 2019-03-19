public class Board {
	private String[][] board;
	
	public Board(){
		board = new String[6][7];
	}

	public void setPiece(String piece,int x,int y){
		board[x][y] = piece;
	}

	public static void insertPiece(String piece, int x) {


	}

	public boolean checkVictory() {


		public boolean checkVictory(int x){
			int y = 0;
			int[][] dir = {{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1},{0,-1}};
			String piece;

			while (board[x][5-y]==null && y>0){
				y--;
			}
			piece = board[x][y];

			for(int i=0;i<dir.length;i++){
				int xMax = x + dir[i][0]*3;
				int yMax = y + dir[i][1]*3;

				if(yMax>=0 && xMax>=0 && yMax<6 && xMax < 7){

				}
			}



			return false;
		}
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
