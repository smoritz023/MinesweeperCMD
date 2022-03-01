import java.util.Scanner;

public class gameState {
    public static void mineSweeper(){
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

            }
            if(mode == 2){

            }
            if(mode == 3){

            }
            if(mode == 4){

            }
            if(mode == 5){
                System.out.println("Exit Selected");
                System.out.println("Goodbye");
                mode = 0;
            }

        }
    }
}
