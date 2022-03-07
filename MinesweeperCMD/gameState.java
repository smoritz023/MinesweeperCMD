import java.util.Scanner;

public class gameState {
    public static void mineSweeper(){
        int x = 0;
        int y = 0;
        int mode = 1;
        int numOfMines = 0;
        boolean gameState = false;
        int turnCounter = 0;
        int xCoord;
        int yCoord;
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper");
        //Menu Select Difficulty
        while(mode > 0 && mode < 6){
            System.out.println("Select Option Below for Difficulty:");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            System.out.println("4) Custom");
            System.out.println("5) EXIT");
            System.out.print("Input: ");
            mode = keyboardInput.nextInt();
            if(mode == 1){
                System.out.println("Easy Mode Selected");
                x = 10;
                y = x;
                numOfMines = 15;
                mode = 0;
            }
            if(mode == 2){
                System.out.println("Medium Mode Selected");
                x = 15;
                y = x;
                numOfMines = 25;
                mode = 0;
            }
            if(mode == 3){
                System.out.println("Hard Mode Selected");
                x = 20;
                y = x;
                numOfMines = 35;
                mode = 0;
            }
            if(mode == 4){
                System.out.println("Custom Mode Selected");
                System.out.print("Board Size Input: ");
                x = keyboardInput.nextInt();
                y = x;
                System.out.print("Number of Mines: ");
                numOfMines = keyboardInput.nextInt();
                mode = 0;
            }
            if(mode == 5){
                System.out.println("Exit Selected");
                System.out.println("Goodbye");
                mode = 0;
            }
            else{
                System.out.println("Please Enter a valid Input");
            }
        }
        //Generating Boards with x valeus
        int[][] playField = boardOps.initializeBoard(x, x);
        int[][] showBoard = boardOps.initializeBoard(x, x);
        gameState = true;
        while(gameState == true){
            if(turnCounter == 0){
                System.out.println("Initial Dig");
                System.out.print("xCoord: ");
                xCoord = keyboardInput.nextInt();
                System.out.print("yCoord: ");
                yCoord = keyboardInput.nextInt();
                // xCoord--;
                // yCoord--;
                if((xCoord >= 0) && (xCoord < x) && (yCoord >= 0) && (yCoord < y)){
                    mineField.placeMines(playField, x, y, numOfMines, xCoord, yCoord);
                    mineField.placeNumbers(playField, x, y);
                    turnCounter++;
                    System.out.println("");
                }
                else{
                    System.out.printf("Coordinates must be within range of 1 - %d", x);
                }
            }
            if(turnCounter > 1){
                
            }
        }
    }

    public static void digFirstHole(int xCoord, int yCoord){

    }
}
