package tictactoe;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        //Create a 3x3 array that represents our tic tac toe board
        char[][] board = new char[3][3];

        //Initialize our board with dashes (empty positions)
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        //Create a Scanner and ask the players for their names
        Scanner in = new Scanner(System.in);

        //Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
        boolean player1 = true;

        //Create a gameEnded boolean and use it as the condition in the while loop
        boolean gameEnded = false;
        while(!gameEnded) {

            //Draw the board
            drawBoard(board);


            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            char c ;
            if(player1) {
                c = 'X';
            } else {
                c = 'O';
            }

            //Create row and col variables which represent indexes that correspond to a position on our board
            int row ;
            int col ;

            //Only break out of the while loop once the user enters a valid position
            while(true) {

                //Ask the user for what position they want to place their x or o
                System.out.println("Enter the coordinates:");
                row = in.nextInt() - 1;
                col = in.nextInt() - 1;

                //Check if the row and col are 0, 1, or 2
                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");

                    //Check if the position on the board the user entered is empty (has a -) or not
                } else if(board[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");

                    //Otherwise, the position is valid so break out of the while loop
                } else {
                    break;
                }

            }

            //Set the position on the board at row, col to c
            board[row][col] = c;

            //Check to see if either player has won
            if(playerHasWon(board) == 'X') {
                drawBoard(board);
                System.out.println("X wins");
                gameEnded = true;
            } else if(playerHasWon(board) == 'O') {
                drawBoard(board);
                System.out.println("O wins");
                gameEnded = true;
            } else {

                //If neither player has won, check to see if there has been a tie (if the board is full)
                if(boardIsFull(board)) {
                    drawBoard(board);
                    System.out.println("Draw");
                    gameEnded = true;
                } else {
                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    player1 = !player1;
                }

            }

        }

        //Draw the board at the end of the game

    }

    //Make a function to draw the tic tac toe board
    public static void drawBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i<3; i++) {
            System.out.print("| ");
            for (int j = 0; j<3; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("---------");
    }

    //Make a function to see if someone has won and return the winning char
    public static char playerHasWon(char[][] board) {

        //Check each row
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
        }

        //Check each column
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return board[0][j];
            }
        }

        //Check the diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != ' ') {
            return board[2][0];
        }

        //Otherwise nobody has not won yet
        return ' ';

    }

    //Make a function to check if all of the positions on the board have been filled
    public static boolean boardIsFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
