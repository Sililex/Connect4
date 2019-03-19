import java.util.Scanner;

public class main {
    private static Board board = new Board();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Hello! Welcome to connect four! Please alternate turns between players.\n" +
                "The aim of the game is to connect four in a row on the board either diagonally,\n" +
                "horizontally or vertically. Press the corresponding number to insert your piece.\n" +
                "\n" +
                "Have fun!");

        ticker(1);
    }

    public static void ticker(int turn) {
        String[] turnStrings = {"x", "o"};
        String turnString = turnStrings[turn % 2];

        System.out.println("\n\n\nTurn: " + Integer.toString(turn));
        board.printBoard();
        System.out.print("It is " + turnString + "'s turn. Press the number you would like to go in: ");
        String input = getColumnInput();
        int location = Integer.parseInt(input) - 1;
        board.insertPiece(turnString, location);
        if (board.checkVictory(location)) {
            board.printBoard();
            victory(turnString);
        } else {
            ticker(turn + 1);
        }
    }

    private static void victory(String victor) {
        System.out.print("Congratulations " + victor + "! You win!");
        System.exit(0);
    }

    private static String getColumnInput() {
        boolean valid = false;
        String input = new String();
        while (!valid) {
            input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if(number < 8 && number > 0 && board.checkEmptyTop(number-1)) {
                    valid = true;
                }
                else{
                    System.out.print("Please put a number between 1-7 without any spaces or other letters\nPress the number you would like to go in: ");
                }
            } catch (Exception e) {
                System.out.print("Please put a number between 1-7 without any spaces or other letters:\nPress the number you would like to go in: ");
            }
        }
        return input;
    }
}