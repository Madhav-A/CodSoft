import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int n = 0;
        boolean repeatGame = true;
        while (repeatGame) {
            int randNum = random.nextInt(100) + 1;
            int numberOfAttempts = 7;
            boolean GuessedCorrect = false;

            System.out.println("Guess a number between 1 and 100. You have only" + numberOfAttempts + " attempts.");

            for (int i = 0; i < numberOfAttempts; i++) {
                System.out.print("Enter your First guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randNum) {
                    System.out.println("Congratulations! You guessed the number correctly.");

                    n++;
                    GuessedCorrect = true;
                    break;
                }
                else if (userGuess < randNum) {
                    System.out.println("Too low please Try again.");
                }
                else {
                    System.out.println("Too high please again.");
                }
            }

            if (!GuessedCorrect) {
                System.out.println("Sorry, you have used all your attempts. The correct number was: " + randNum);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();
            repeatGame = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Your final score is: " + n);

        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
