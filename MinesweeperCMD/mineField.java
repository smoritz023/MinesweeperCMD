// import java.util.Scanner;
import java.util.Random;

public class mineField {

    public static int[][] digHole(int[][] board, int[][] showBoard, int xCoord, int yCoord, int xMax, int yMax){
        if((xCoord > 0) && (xCoord < xMax) && (yCoord > 0) && (xCoord < yMax)){
            if(board[xCoord][yCoord] == 10){
                System.out.println("hit a mine at " + xCoord + ":" + yCoord);
            }
            else if((board[xCoord][yCoord] > 0) && (board[xCoord][yCoord] < 9)){
                System.out.println("hit a number at " + xCoord + ":" + yCoord);
                return board;
                // showBoard[adjustedX][adjustedY] = 1;
            }
            else{
                if((xCoord > 1) && (xCoord < xMax-1) && (yCoord > 1) && (yCoord < yMax-1)){
                    showBoard[xCoord][yCoord] = 1;
                    // //up/left recursion
                    // if((showBoard[xCoord-1][yCoord-1] == 0) && ((xCoord-1 < xMax) && (yCoord-1 < yMax))){
                    //     showBoard[xCoord][yCoord] = 1;
                    //     digHole(board, showBoard, xCoord-1, yCoord-1, xMax, yMax);
                    // }
                    //up recursion
                    if((showBoard[xCoord-1][yCoord] == 0) && ((xCoord-1 < xMax) && (yCoord < yMax))){
                        showBoard[xCoord][yCoord] = 1;
                        digHole(board, showBoard, xCoord-1, yCoord, xMax, yMax);
                    }
                    // //up/right recursion
                    // if((showBoard[xCoord-1][yCoord+1] == 0) && ((xCoord-1 < xMax) && (yCoord+1 < yMax))){
                    //     showBoard[xCoord][yCoord] = 1;
                    //     digHole(board, showBoard, xCoord-1, yCoord+1, xMax, yMax);
                    // }
                    //right recursion
                    if((showBoard[xCoord][yCoord+1] == 0) && ((xCoord < xMax) && (yCoord+1 < yMax))){
                        showBoard[xCoord][yCoord] = 1;
                        digHole(board, showBoard, xCoord, yCoord+1, xMax, yMax);
                    }
                    // //down right recursion
                    // if((showBoard[xCoord+1][yCoord+1] == 0) && ((xCoord+1) < xMax) && (yCoord+1 < yMax)){
                    //     showBoard[xCoord][yCoord] = 1;
                    //     digHole(board, showBoard, xCoord+1, yCoord+1, xMax, yMax);
                    // }
                    //bottom recursion
                    if((showBoard[xCoord+1][yCoord] == 0) && ((xCoord+1 < xMax) && (yCoord < yMax))){
                        showBoard[xCoord][yCoord] = 1;
                        digHole(board, showBoard, xCoord+1, yCoord, xMax, yMax);
                    }
                    // //bottom left recursion
                    // if((showBoard[xCoord+1][yCoord-1] == 0) && ((xCoord+1 < xMax) && (yCoord-1 < yMax))){
                    //     showBoard[xCoord][yCoord] = 1;
                    //     digHole(board, showBoard, xCoord+1, yCoord-1, xMax, yMax);
                    // }
                    //left recursion
                    if((showBoard[xCoord][yCoord-1] == 0) && ((xCoord < xMax) && (yCoord-1 < yMax))){
                        showBoard[xCoord][yCoord] = 1;
                        digHole(board, showBoard, xCoord, yCoord-1, xMax, yMax);
                    }
                }
            }
        }
        return board;
    }

    public static int[][] placeMines(int[][] board, int xMax, int yMax, int d, int xCoord, int yCoord){
        Random rand = new Random();
        while(d > 0){
            int randX = rand.nextInt(xMax);
            int randY = rand.nextInt(yMax);
            if((board[randY][randX] != 10) &&
                    (randX != xCoord) && (randX != (xCoord-1)) && (randX != (xCoord+1)) &&
                    (randY != yCoord) && (randY != (yCoord-1)) && (randY != (yCoord+1))){
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
}
