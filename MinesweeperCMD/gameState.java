import java.util.Scanner;

public class gameState {
    public static void mineSweeper(){
        int x = 0;
        int y = 0;
        int mode = 1;
        System.out.println("Welcome to MineSweeper");
        while(mode > 0){
            System.out.println("Select Option Below for Difficulty:");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            System.out.println("4) Custom");
            System.out.println("5) EXIT");
            System.out.print("Input: ");
            Scanner keyboardInput = new Scanner(System.in);
            mode = keyboardInput.nextInt();
            if(mode == 1){
                System.out.println("Easy Mode Selected");
                x = 10;
            }
            if(mode == 2){
                System.out.println("Medium Mode Selected");
                x = 15;
            }
            if(mode == 3){
                System.out.println("Hard Mode Selected");
                x = 20;
            }
            if(mode == 4){
                System.out.println("Custom Mode Selected");
                System.out.print("Board Size Input: ");
                x = keyboardInput.nextInt();
                y = x;
            }
            if(mode == 5){
                System.out.println("Exit Selected");
                System.out.println("Goodbye");
                mode = 0;
            }
            int[][] playField = boardOps.initializeBoard(x, y);
            int[][] showBoard = boardOps.initializeBoard(x, y);
            


        }
    }

    public static void digFirstHole(int xCoord, int yCoord){

    }
}
