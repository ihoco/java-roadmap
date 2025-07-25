import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Welcome to the guess number game! i already got a number between 1 to 100. Let us guess!");

        while (true) {
            System.out.print("Please enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congrats! Answer is " + secretNumber);
                System.out.println("You already guessed " + attempts + "times.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("too little, try again!");
            } else {
                System.out.println("too much, try again!");
            }
        }


        System.out.println("The game ends, thx!");

    }

}
