import java.util.Scanner;

public class MyTicTacToe {
    private static char[][] myBoard = new char[3][3];
    private static char myCurrentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        while (!isGameOver()) {
            playMove();
            printBoard();
            if (isWinner()) {
                System.out.println("Player " + myCurrentPlayer + " wins!");
                return;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                return;
            }
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                myBoard[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(myBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + myCurrentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));
        myBoard[row][col] = myCurrentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || myBoard[row][col] != '-') {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        return true;
    }

    private static boolean isGameOver() {
        return isWinner() || isBoardFull();
    }

    private static boolean isWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (myBoard[i][0] != '-' && myBoard[i][0] == myBoard[i][1] && myBoard[i][0] == myBoard[i][2]) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (myBoard[0][j] != '-' && myBoard[0][j] == myBoard[1][j] && myBoard[0][j] == myBoard[2][j]) {
                return true;
            }
        }
        // Check diagonals
        if (myBoard[0][0] != '-' && myBoard[0][0] == myBoard[1][1] && myBoard[0][0] == myBoard[2][2]) {
            return true;
        }
        if (myBoard[0][2] != '-' && myBoard[0][2] == myBoard[1][1] && myBoard[0][2] == myBoard[2][0]) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (myBoard[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        myCurrentPlayer = (myCurrentPlayer == 'X') ? 'O' : 'X';
    }
}