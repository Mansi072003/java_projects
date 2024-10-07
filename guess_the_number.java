import java.util.Random;
import java.util.Scanner;

public class guess_the_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            Random rand = new Random();
            int numberToGuess = rand.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            final int maxAttempts = 12;

            System.out.println("Welcome to the number guessing game!");
            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts:");

            while (attempts < maxAttempts) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100:");
                    scanner.next(); // discard invalid input
                }
                guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations, you guessed the number!");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again:");
                } else {
                    System.out.println("Your guess is too high. Try again:");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        scanner.close();
    }
}