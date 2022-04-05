import java.util.Scanner;

public class gameState {
    public static void mineSweeper(){
        int x = 0;
        int y = 0;
        int mode = 1;
        int numOfMines = 0;
        int numOfFlagsRemain = 0;
        boolean gameState = false;
        int turnCounter = 0;
        int xCoord;
        int yCoord;
        int openSpotCount = 0;
        boolean diffSelector = true;
        gameState = true;
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper");
        //Menu Select Difficulty
        while(diffSelector = true){
            System.out.println("Select Option Below for Difficulty:");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            System.out.println("4) Custom");
            System.out.println("5) EXIT");
            System.out.print("Input: ");
            mode = keyboardInput.nextInt();
            if((mode > 0) && (mode < 6)){
                if(mode == 1){
                    System.out.println("Easy Mode Selected");
                    x = 10;
                    y = x;
                    numOfMines = 15;
                    numOfFlagsRemain = numOfMines;
                    break;
                }
                if(mode == 2){
                    System.out.println("Medium Mode Selected");
                    x = 15;
                    y = x;
                    numOfMines = 25;
                    numOfFlagsRemain = numOfMines;
                    break;
                }
                if(mode == 3){
                    System.out.println("Hard Mode Selected");
                    x = 20;
                    y = x;
                    numOfMines = 35;
                    numOfFlagsRemain = numOfMines;
                    break;
                }
                if(mode == 4){
                    System.out.println("Custom Mode Selected");
                    System.out.print("Board Size Input: ");
                    x = keyboardInput.nextInt();
                    y = x;
                    System.out.print("Number of Mines: ");
                    numOfMines = keyboardInput.nextInt();
                    numOfFlagsRemain = numOfMines;
                    break;
                }
                if(mode == 5){
                    System.out.println("Exit Selected");
                    System.out.println("Goodbye");
                    gameState = false;
                    break;
                }
            }
            else{
                System.out.println("\tPlease Enter a valid Input\n");
            }

        }
        //Generating Boards with x valeus
        int[][] playField = mines.initializeBoard(x, x);
        int[][] showBoard = mines.initializeBoard(x, x);
        while(gameState == true){
            if(turnCounter == 0){
                System.out.println("Initial Dig");
                System.out.print("xCoord: ");
                yCoord = keyboardInput.nextInt();
                System.out.print("yCoord: ");
                xCoord = keyboardInput.nextInt();
                //adjusting to index starting at 0
                xCoord--;
                yCoord--;
                if((xCoord >= 0) && (xCoord < x) && (yCoord >= 0) && (yCoord < y)){
                    mineField.placeMines(playField, x, y, numOfMines, xCoord, yCoord);
                    mineField.placeNumbers(playField, x, y);
                    mineField.digHole(playField, showBoard, xCoord, yCoord, x, y);
                    turnCounter++;

                    System.out.printf("x: %d,y: %d\n", yCoord,xCoord);
                    mines.printShowBoard(playField, showBoard, x, y);
                }
                else{
                    System.out.printf("Coordinates must be within range of 1 - %d\n", x);
                }
            }
            if(turnCounter >= 1){
                boolean inTurn = true;
                while(inTurn){
                    //if a wincondition is found a win condition
                    if(openSpotCount == numOfMines){
                        System.out.println();
                        System.out.println("All mines found");
                        System.out.println("Exiting Game...");
                        System.out.println();
                        gameState = false;
                        inTurn = false;
                        break;
                    }

                    System.out.println();
                    System.out.printf("Turn #%d\n", turnCounter);
                    System.out.printf("Number of flags remaining: #%d\n", numOfFlagsRemain);
                    System.out.println("1) To dig a hole");
                    System.out.println("2) To place a flag");
                    System.out.println("3) To remove a flag");
                    System.out.println("4) Exit Game");
                    System.out.print("Input: ");
                    int turnDecision = keyboardInput.nextInt();

                    // System.out.println();
                    if(turnDecision < 1 && turnDecision > 4){
                        System.out.println("Please enter a valid number (1-4)");
                    }
                    else if(turnDecision == 1){
                        System.out.println("Dig hole at: **for abort enter 100");
                        System.out.print("xCoord: ");
                        yCoord = keyboardInput.nextInt() - 1;
                        System.out.print("yCoord: ");
                        xCoord = keyboardInput.nextInt() - 1;
                        //adjusting to index starting at 0
                        // xCoord--;
                        // yCoord--;
                        if((xCoord >= 0) && (xCoord < x) && (yCoord >= 0) && (yCoord < y)){
                            if(showBoard[xCoord][yCoord] == 9){
                                numOfFlagsRemain++;
                            }
                            mineField.digHole(playField, showBoard, xCoord, yCoord, x, y);
                            // System.out.println("here " + yCoord + ":" + xCoord + " = " + playField[yCoord][xCoord]);
                            if(playField[xCoord][yCoord] == 10){
                                System.out.println();
                                System.out.println("GAME OVER");
                                System.out.printf("Hit a mine at %d,%d", yCoord+1, xCoord+1);
                                System.out.println();
                                System.out.println();
                                inTurn = false;
                                gameState = false;
                                break;
                            }
                            turnCounter++;
                            openSpotCount = mines.winConditionChecker(showBoard, numOfMines, openSpotCount, x, y);
        
                            System.out.printf("x: %d,y: %d\n", yCoord,xCoord);
                            mines.printShowBoard(playField, showBoard, x, y);
                            turnCounter++;
                        }
                        else{
                            System.out.printf("Coordinates must be within range of 1 - %d\n", x);
                        }
                    }
                    else if(turnDecision == 2){
                        if(numOfFlagsRemain > 0){
                            System.out.println("Place flag at at: **for abort enter 100");
                            System.out.print("xCoord: ");
                            yCoord = keyboardInput.nextInt() - 1;
                            System.out.print("yCoord: ");
                            xCoord = keyboardInput.nextInt() - 1;
                            if((xCoord >= 0) && (xCoord < x) && (yCoord >= 0) && (yCoord < y)){
                                if((showBoard[xCoord][yCoord] != 1 && showBoard[xCoord][yCoord] != 9)){
                                    mineField.placeFlag(showBoard, xCoord, yCoord);
                                    System.out.printf("x: %d,y: %d\n", yCoord,xCoord);
                                    mines.printShowBoard(playField, showBoard, x, y);
                                    turnCounter++;
                                    numOfFlagsRemain--;
                                    openSpotCount = mines.winConditionChecker(showBoard, numOfMines, openSpotCount, x, y);
                                }
                                else if(showBoard[xCoord][yCoord] == 1){
                                    System.out.println("Space has already been cleared");
                                }
                                else if(showBoard[xCoord][yCoord] == 9){
                                    System.out.println("Flag already has been placed here");
                                }
                            }
                            else{
                                System.out.printf("Coordinates must be within range of 1 - %d\n", x);
                            }
                        }
                        else{
                            System.out.println("0 Flags Remaining, unable to place flag");
                        }

                    }
                    else if(turnDecision == 3){
                        System.out.println("Remove flag at at: **for abort enter 100");
                        System.out.print("xCoord: ");
                        yCoord = keyboardInput.nextInt() - 1;
                        System.out.print("yCoord: ");
                        xCoord = keyboardInput.nextInt() - 1;
                        if((xCoord >= 0) && (xCoord < x) && (yCoord >= 0) && (yCoord < y)){
                            if(showBoard[xCoord][yCoord] != 9){
                                System.out.println("No flag to remove here");
                            }
                            else{
                                mineField.removeFlag(showBoard, xCoord, yCoord);
                                System.out.printf("x: %d,y: %d\n", yCoord,xCoord);
                                mines.printShowBoard(playField, showBoard, x, y);
                                turnCounter++;
                                numOfFlagsRemain++;
                                openSpotCount = mines.winConditionChecker(showBoard, numOfMines, openSpotCount, x, y);
                            }
                        }
                    }
                    else if(turnDecision == 4){
                        System.out.println("Aborting Game...");
                        System.out.println("Goodbye");
                        gameState = false;
                        inTurn = false;
                        break;
                    }
                }
                turnCounter++;
            }
        }
        keyboardInput.close();
    }

}
