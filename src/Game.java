public class Game {
    private SelectWord selectWord;
    private DisplayResult displayResult;
    private PlayerInteraction playerInteraction;
    private final int INITIAL_LIVES = 6;

    public Game() {
        selectWord = new SelectWord();
        displayResult = new DisplayResult(selectWord.getSelectedWord(), INITIAL_LIVES);
        playerInteraction = new PlayerInteraction();
    }

    public void start() {
        playerInteraction.showMessage("Welcome to Hangman!");

        while (!displayResult.isWordGuessed() && !displayResult.isOutOfLives()) {
            displayResult.showDisplayResult();
            char guess = playerInteraction.getGuess();
            if (selectWord.getSelectedWord().indexOf(guess) >= 0) {
                displayResult.updateDisplayResult(guess);
            } else {
                displayResult.decrementLives();
                playerInteraction.showMessage("Incorrect guess. You lost a life.");
            }
        }

        if (displayResult.isWordGuessed()) {
            playerInteraction.showMessage("Congratulations! You've guessed the word: " + selectWord.getSelectedWord());
        } else {
            playerInteraction.showMessage("Game over! The word was: " + selectWord.getSelectedWord());
        }
    }



    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
