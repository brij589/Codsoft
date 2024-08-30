import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_TRIES = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game! Try to guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

        int totalScore = 0;
        int gamesPlayed = 0;
        String continuePlaying = "yes";

        while (continuePlaying.equalsIgnoreCase("yes")) {
            gamesPlayed++;
            System.out.println("Game " + gamesPlayed);
            int tries = playRound(input);

            if (tries <= MAX_TRIES) {
                totalScore += (MAX_TRIES - tries + 1);
            }

            System.out.println("Current score: " + totalScore);
            System.out.print("Would you like to play another game? (yes/no): ");
            continuePlaying = input.next();
        }

        System.out.println("Thanks for playing! You participated in " + gamesPlayed + " games and scored a total of " + totalScore + ".");
        input.close();
    }

    private static int playRound(Scanner input) {
        int targetNumber = generateRandomNumber(LOWER_BOUND, UPPER_BOUND);
        int numberOfTries = 0;

        while (numberOfTries < MAX_TRIES) {
            int userGuess = getUserGuess(input);
            numberOfTries++;
            String result = evaluateGuess(userGuess, targetNumber);
            System.out.println(result);

            if (result.equals("You guessed it right!")) {
                return numberOfTries;
            }
        }

        System.out.println("Out of tries! The number was " + targetNumber + ".");
        return MAX_TRIES + 1;
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    private static int getUserGuess(Scanner input) {
        while (true) {
            try {
                System.out.print("Make your guess: ");
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("That's not a number. Please enter a valid integer.");
            }
        }
    }

    private static String evaluateGuess(int guess, int targetNumber) {
        if (guess < targetNumber) {
            return "Too low!";
        } else if (guess > targetNumber) {
            return "Too high!";
        } else {
            return "You guessed it right!";
        }
    }
}
