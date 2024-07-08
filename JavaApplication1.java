import java.util.Random;
import java.util.Scanner;

public class JavaApplication1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;
        
        while (playAgain) {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 10;
            
            System.out.println("Round " + rounds + ": I have selected a number between 1 and 100. Can you guess it?");
            
            while (numberOfAttempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                totalAttempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
                    guessedCorrectly = true;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was: " + numberToGuess);
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}