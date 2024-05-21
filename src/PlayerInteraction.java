import java.util.Scanner;

public class PlayerInteraction {
    private Scanner scanner;

    public PlayerInteraction() {
        scanner = new Scanner(System.in);
    }

    public char getGuess() {
        System.out.print("Enter a letter as your guess: ");
        String input = scanner.nextLine();
        if (input.length() != 1) {
            System.out.println("Invalid input. Please enter a single letter.");
            return getGuess();
        }
        return input.charAt(0);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
