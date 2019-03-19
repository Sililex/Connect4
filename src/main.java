public class main {
    private static Board board = new Board();
    public static void main(String[] args) {
        System.out.print("Hello! Welcome to connect four! Please alternate turns between players.\n" +
                "The aim of the game is to connect four in a row on the board either diagonally,\n" +
                "horizontally or vertically. Press the corresponding number to insert your piece.\n" +
                "\n" +
                "Have fun!");

        ticker(1);
    }

    public static void ticker(int turn) {
        String[] turnStrings = {"x","o"};
        String turnString = turnStrings[turn%2];

        System.out.println("\n\n\nTurn: " + Integer.toString(turn));
        board.printBoard();
        System.out.print("It is " + turnString + "'s turn. Press the number you would like to go in.");
        int location = Integer.parseInt(System.console().readLine());
        board.insertPiece(turnString, location);
        if(board.checkVictory()){
            victory(turnString);
        }
        else{
            ticker(turn + 1);
        }
    }

    private static void victory(String victor) {
        System.out.print("Congratulations " + victor + "! You win!");
        System.exit(1);
    }
};