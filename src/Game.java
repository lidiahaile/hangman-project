public class Game {
    private SelectWord selectWord;
    private DisplayResult displayResult;
    private PlayerInteraction playerInteraction;
    private final int INITIAL_LIVES = 8;

    public Game() {
        selectWord = new SelectWord();
        playerInteraction = new PlayerInteraction();
        displayResult = new DisplayResult(selectWord.getSelectedWord(), INITIAL_LIVES);

    }

    public void start() {
        playerInteraction.showMessage("Welcome to Hangman!");

        while (!displayResult.isWordGuessed() && !displayResult.isOutOfLives()) {
            displayResult.showDisplayResult();
            String guess = playerInteraction.getGuess();

            if (guess.length() == 1) {
                char letterGuess = guess.charAt(0);
                if (selectWord.getSelectedWord().indexOf(letterGuess) >= 0) {
                    displayResult.updateDisplayResult(letterGuess);
                } else {
                    displayResult.decrementLives();
                    playerInteraction.showMessage("Incorrect guess. You lost a life.");
                }
            } else {
                if (guess.equals(selectWord.getSelectedWord())) {
                    playerInteraction.showMessage("Well done! You've guessed the word: " + selectWord.getSelectedWord());
                    return;
                } else {
                    displayResult.decrementLives();
                    playerInteraction.showMessage("Incorrect guess. You lost a life.");
                }
            }
        }

        if (displayResult.isWordGuessed()) {
            playerInteraction.showMessage("You won! You've guessed the word: " + selectWord.getSelectedWord());
        } else {
            playerInteraction.showMessage("You have lost! The word was: " + selectWord.getSelectedWord());
        }
    }



    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
