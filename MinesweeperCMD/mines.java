import java.util.Scanner;
import java.util.Random;

public class mines {
    public static void main(String[] args){
        // Scanner keyboardInput = new Scanner(System.in);
        // System.out.print("Enter how large you would like the board to be: ");
        // int x = keyboardInput.nextInt();
        // keyboardInput.close();

        // System.out.println("your x/y values are: [" + x + "," + y + "]");

        // this x and y set the size of the board in the x and y axis
        int x = 15;
        int y = x;

        //number of mines
        // int d = (x * y) / 2;
        // d = 1;
        int d = 15;
        
        int[][] playField = initializeBoard(x, y);
        int[][] showBoard = initializeBoard(x, y);

        // printBoard(playField, x, y);

        placeMines(playField, x, y, d);
        // System.out.println("Randomly place mines");
        // printBoard(playField, x, y);

        placeNumbers(playField, x, y);
        // printBoard(playField, showBoard, x, y);

        digHole(playField, showBoard, 4, 6);
        // printBoard(playField, showBoard, x, y);

        System.out.println("\nprint showBoard");
        printShowBoard(playField, showBoard, x, y);
        printMineBoard(playField, showBoard, x, y);
    }

    public static void printShowBoard(int[][] board, int[][] showBoard, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                // board[0][1] = 99;
                if(showBoard[i][j] == 1){
                    if(board[i][j] == 9){
                        System.out.print("F" + " ");
                    }
                    else if(board[i][j] == 10){
                        System.out.print("M" + " ");
                    }
                    else if(board[i][j] == 0){
                        System.out.print("0" + " ");
                    }
                    else if((board[i][j] > 0) && (board[i][j] < 9)){
                        System.out.print(board[i][j] + " ");
                    }
                    else{
                        System.out.print(board[i][j] + " ");
                    }
                }
                else if(showBoard[i][j] == 0){
                    System.out.print(" " + " ");
                }

            }
            System.out.println();
        }
    }

    public static void printMineBoard(int[][] board, int[][] showBoard, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] initializeBoard(int x, int y){
        int[][] board = new int[y][x];  //////
        return board;
    }

    public static int[][] setShowBoard(int[][] showBoard, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; i++){
                showBoard[i][j] = 0;
            }
        }
        return showBoard;
    }

    public static int[][] placeMines(int[][] board, int x, int y, int d){
        Random rand = new Random();
        while(d > 0){
            int randX = rand.nextInt(x);
            int randY = rand.nextInt(y);
            if(board[randY][randX] != 10){
                board[randY][randX] = 10;
                // System.out.println("Mines remaining " + d);
                d--;
            }
            // board[3][5] = 10;
        }
        return board;
    }

    public static int[][] placeNumbers(int[][] board, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                int neighborMinesCount = 0;
                // int iPos = i;
                // int jPos = j;
                if(board[i][j] != 10){
                    //one step inside from all sides for easiest checker
                    if((i > 0) && (i < x - 1) && (j > 0) && (j < y - 1) && (board[i][j] != 10)) {
                        if(board[i-1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                    }
                    //top left corner
                    if((i == 0) && (j == 0) && (board[i][j] != 10)){
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                    }
                    // top side of board between corners
                    if((j > 0) && (i == 0) && (j < (x-1)) && (board[i][j] != 10)){
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        }
                    }
                    
                    //top right corner
                    if((i == 0) && (j == (y-1)) && (board[i][j] != 10)){
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                    }

                    //right side of board
                    if((i > 0) && (i < (x-1)) && (j == (x-1)) && (board[i][j] != 10)){
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        } 
                        if(board[i-1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                    }

                    //bottom right corner
                    if((i == (x-1)) && (j == (y-1)) && (board[i][j] != 10)){
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                    }

                    //bottom side of board
                    if((i == (x-1)) && (j > 0) && (j < (x-1)) && (board[i][j] != 10)){
                        if(board[i][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j-1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                    }

                    //bottom left corner
                    if((i== (x-1)) && (j == 0) && board[i][j] != 10){
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                    }

                    //left side of board
                    if((j == 0) && (i > 0) && (i < (x-1)) && (board[i][j] != 10)){
                        if(board[i-1][j] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i-1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j+1] == 10){
                            neighborMinesCount++;
                        }
                        if(board[i+1][j] == 10){
                            neighborMinesCount++;
                        }
                    }

                    board[i][j] = neighborMinesCount;
                }
                
                // if((j > 0) && (j < y)){

                // }
            }
        }
        return board;
    }

    public static int[][] digHole(int[][] board, int[][] showBoard, int x, int y){
        int adjustedX = x - 1;
        int adjustedY = y - 1;
        // board[adjustedX][adjustedY] = 90;
        if((adjustedX >= 0) && (adjustedX <= x) && (adjustedY >= 0) && (adjustedX <= y) && (showBoard[adjustedX][adjustedY] == 0)){
            if(board[adjustedX][adjustedY] == 10){
                System.out.println("hit a bomb at " + adjustedX + ":" + adjustedY);
            }
            else if((board[adjustedX][adjustedY] > 0) && (board[adjustedX][adjustedY] < 9)){
                System.out.println("hit a number at " + adjustedX + ":" + adjustedY);
                return board;
            }
            else{
                if((adjustedX > 0) && (adjustedX < x) && (adjustedY > 0) && (adjustedY < y)){
                    System.out.println("hit a zero at " + adjustedX + ":" + adjustedY);
                    digHole(board, showBoard, adjustedX-1, adjustedY-1);
                    digHole(board, showBoard, adjustedX, adjustedY-1);
                    digHole(board, showBoard, adjustedX+1, adjustedY-1);
                    digHole(board, showBoard, adjustedX+1, adjustedY);
                    // digHole(board, adjustedX+1, adjustedY+1);
                    digHole(board, showBoard, adjustedX, adjustedY+1);
                    digHole(board, showBoard, adjustedX-1, adjustedY+1);
                    digHole(board, showBoard, adjustedX-1, adjustedY);
                }
            }
            showBoard[adjustedX][adjustedY] = 1;
        }
        return board;
    }
}
