import java.util.Scanner;
import java.util.Random;

public class NumberGuesingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        // Set the range for the random number
        int lowerLimit = 1;
        int upperLimit = 100;

        // Initialize score
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nRound " + (roundsWon + 1));
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;
            final int maxAttempts = 3; // Allow the user to guess three times

            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit);

            while (attempts < maxAttempts) {
                try {
                    // Prompt the user to enter their guess
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();

                    // Compare the user's guess with the generated number
                    if (userGuess == secretNumber) {
                        System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                                " in " + (attempts + 1) + " attempts.");
                        roundsWon++;
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }

                    attempts++;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " +
                        secretNumber + ".");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                System.out.println("Your final score: " + roundsWon + " " + (roundsWon == 1 ? "round" : "rounds") + " won.");
                playAgain = false;
            }
        }

        scanner.close();
    }
}
