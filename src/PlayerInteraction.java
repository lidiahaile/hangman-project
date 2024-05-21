import java.util.Scanner;

public class PlayerInteraction {
    private Scanner scanner;

    public PlayerInteraction() {
        scanner = new Scanner(System.in);
    }



    public String getGuess() {
        System.out.print("Enter your guessed letter or word: ");
        String input = scanner.nextLine();
        return input.toLowerCase();
    }



    public void showMessage(String message) {
        System.out.println(message);
    }
}



