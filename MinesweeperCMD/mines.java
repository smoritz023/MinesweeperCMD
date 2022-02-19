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

        // printBoard(playField, x, y);

        placeMines(playField, x, y, d);
        // System.out.println("Randomly place mines");
        // printBoard(playField, x, y);

        placeNumbers(playField, x, y);
        printBoard(playField, x, y);
    }

    public static void printBoard(int[][] board, int x, int y){
        System.out.println("");
        System.out.println("Print Board Method");
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                // board[0][1] = 99;
                if(board[i][j] == 9){
                    System.out.print("F" + " ");
                }
                else if(board[i][j] == 10){
                    System.out.print("M" + " ");
                }
                else if(board[i][j] == 0){
                    System.out.print("0" + " ");
                }
                else{
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] initializeBoard(int x, int y){
        int[][] board = new int[y][x];  //////
        return board;
    }


    public static int[][] placeMines(int[][] board, int x, int y, int d){
        Random rand = new Random();
        while(d > 0){
            int randX = rand.nextInt(x);
            int randY = rand.nextInt(y);
            if(board[randY][randX] != 10){
                board[randY][randX] = 10;
                System.out.println("Mines remaining " + d);
                d--;
            }
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
}
