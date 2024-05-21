import java.util.Random;

public class SelectWord {
    private String[] words = {"hangman", "restaurant", "online", "documentation", "computer", "game"};
    private String wordSelected;

    public SelectWord() {
        Random random = new Random();
        wordSelected = words[random.nextInt(words.length)];
    }

    public String getSelectedWord() {

        return  wordSelected;
    }
}