import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int rounds = 0;

        do {
            rounds++;
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("Round " + rounds + ":");
            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerLimit || userGuess > upperLimit) {
                    System.out.println("Your guess is out of the specified range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your average attempts per round: " + (double) totalAttempts / rounds);
                break;
            }
        } while (true);

        scanner.close();
    }
}
