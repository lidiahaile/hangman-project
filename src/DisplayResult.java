public class DisplayResult {
    private String wordSelected;
    private char[] currentGuess;
    private int lives;

    public DisplayResult(String wordSelected, int lives) {
        this.wordSelected = wordSelected;
        this.lives = lives;
        currentGuess = new char[wordSelected.length()];
        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }
    }


    public void updateDisplayResult(char guess) {
        for (int i = 0; i < wordSelected.length(); i++) {
            if (wordSelected.charAt(i) == guess) {
                currentGuess[i] = guess;
            }
        }
    }



    public void showDisplayResult() {
        System.out.println("Current Guess: " + new String(currentGuess));
        System.out.println("Remaining Lives: " + lives);
    }

    public void decrementLives() {
        lives--;
    }

    public boolean isWordGuessed() {
        for (char c : currentGuess) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean isOutOfLives() {
        return lives <= 0;
    }
}

