package numbeguess;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private int minRange;
    private int maxRange;
    private int randomNumber;
    private int maxAttempts;
    private int attempts;

    public NumberGuessingGame(int minRange, int maxRange, int maxAttempts) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.maxAttempts = maxAttempts;
        Random rand = new Random();
        this.randomNumber = rand.nextInt((maxRange - minRange) + 1) + minRange;
        this.attempts = 0;
    }

    public void playGame() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ".");
        System.out.println("Try to guess it within " + maxAttempts + " attempts.");

        Scanner scanner = new Scanner(System.in);
        int guess;
        boolean hasGuessedCorrectly = false;

        while (attempts < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < minRange || guess > maxRange) {
                System.out.println("Your guess is out of range. Please guess between " + minRange + " and " + maxRange + ".");
            } else {
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;

        NumberGuessingGame game = new NumberGuessingGame(minRange, maxRange, maxAttempts);
        game.playGame();
    }
}
