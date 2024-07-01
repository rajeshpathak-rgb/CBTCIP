import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        guessingNumberGame();
    }

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int maxAttempts = 15;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("Guess the number within " + maxAttempts + " trials.");

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            if (number == guess) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (number > guess) {
                System.out.println("The number is greater than " + guess);
            } else {
                System.out.println("The number is less than " + guess);
            }
        }

        if (number != sc.nextInt()) {
            System.out.println("You have exhausted " + maxAttempts + " trials.");
            System.out.println("The correct number was " + number);
        }
    }
}
