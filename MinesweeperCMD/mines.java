// import javax.swing.text.StyledEditorKit.UnderlineAction;

// import java.util.Random;

public class mines {
    public static void main(String[] args){
        gameState.mineSweeper();
    }

    public static void printShowBoard(int[][] board, int[][] showBoard, int x, int y){
        // System.out.println("Len  " + showBoard.length);
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                if(i == 0 && j == 0){
                    for(int a = 0; a < x; a++){
                        if(a == 0){
                            System.out.print("     " + 1 + "  ");
                        }
                        if((a > 0) && (a < 9)){
                            System.out.print(a+1 + "  ");
                        }
                        if((a > 0) && (a > 8)){
                            System.out.print(a+1 + " ");
                        }
                    }
                    System.out.println();
                    for(int a = 0; a < x; a++){
                        if(a == 0){
                            System.out.print("   _" + "___");
                        }
                        if((a > 0) && (a < 9)){
                            System.out.print("___");
                        }
                        if((a > 0) && (a > 8)){
                            System.out.print("___");
                        }
                    }
                    System.out.println();
                }
                    
                if(j == 0 && i < 9){
                    System.out.print(i+1 + "  | ");
                }
                if(j == 0 && i > 8){
                    System.out.print(i+1 + " | ");
                }
                if(j < 10){
                    if(showBoard[i][j] == 1 || showBoard[i][j] == 9){
                        if(showBoard[i][j] == 9){
                            System.out.print("F" + "  ");
                        }
                        else if(board[i][j] == 10){
                            System.out.print("M" + "  ");
                        }
                        else if(board[i][j] == 0){
                            System.out.print("0" + "  ");
                        }
                        else if((board[i][j] > 0) && (board[i][j] < 9)){
                            System.out.print(board[i][j] + "  ");
                        }
                        else{
                            System.out.print(board[i][j] + "  ");
                        }
                    }
                    else if(showBoard[i][j] == 0){
                        System.out.print(" " + "  ");
                    }
                }
                if(j > 9){
                    if(showBoard[i][j] == 1 || showBoard[i][j] == 9){
                        if(showBoard[i][j] == 9){
                            System.out.print("F" + "  ");
                        }
                        else if(board[i][j] == 10){
                            System.out.print("M" + "  ");
                        }
                        else if(board[i][j] == 0){
                            System.out.print("0" + "  ");
                        }
                        else if((board[i][j] > 0) && (board[i][j] < 9)){
                            System.out.print(board[i][j] + "  ");
                        }
                        else{
                            System.out.print(board[i][j] + "  ");
                        }
                    }
                    else if(showBoard[i][j] == 0){
                        System.out.print(" " + "  ");
                    }
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

    public static int winConditionChecker(int[][] showBoard, int mineCount, int spotCount, int x, int y){
        spotCount = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(showBoard[i][j] != 1){
                    spotCount++;
                }
            }
        }
        System.out.println("Spot Count: " + spotCount);
        return spotCount;
    }

    public static int[][] initializeBoard(int x, int y){
        int[][] board = new int[y][x];  //////
        return board;
    }
}
