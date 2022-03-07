// import java.util.Random;

public class mines {
    public static void main(String[] args){

        gameState.mineSweeper();
        
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
        int d = 30;

        int xCoord = 5;
        int yCoord = 5;
        
        int[][] playField = boardOps.initializeBoard(x, y);
        int[][] showBoard = boardOps.initializeBoard(x, y);


        mineField.placeMines(playField, x, y, d, xCoord, yCoord);
        // System.out.println("Randomly place mines");
        // printBoard(playField, x, y);

        mineField.placeNumbers(playField, x, y);
        // printBoard(playField, showBoard, x, y);

        mineField.digHole(playField, showBoard, xCoord, yCoord, x, y);
        System.out.println("dig hole at x,y"); 
        mineField.digHole(playField, showBoard, x-1, y-1, x, y);
        System.out.println("dig hole at x-1,y-1");
        mineField.digHole(playField, showBoard, 0, y-1, x, y);
        System.out.println("dig holde at x-1,0");
        System.out.println("");

        printShowBoard(playField, showBoard, x, y);
        System.out.println("");

        System.out.println("end");

        // printMineBoard(playField, showBoard, x, y);
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
            System.out.println();
        }
    }



    public static int[][] setShowBoard(int[][] showBoard, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; i++){
                showBoard[i][j] = 0;
            }
        }
        return showBoard;
    }



    

    
}
