import java.util.Arrays;
import java.util.Scanner;

public class Hangman
{
    String word;
    char[] userWord;
    int lives = 3;
    ScannerValidator scannerValidator = new HangmanValidator();
    public void play()
    {
        System.out.println("Start of the game.");

        word = createWord();
        System.out.println(".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\nA secret word has been saved!");

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        Scanner scanner = new Scanner(System.in);

        while (!gameEnded())
        {
            System.out.println(userWord);
            System.out.println();
            System.out.println("You have: " + lives + " lives.");
            System.out.println("Provide next letter: ");

            char letter = scannerValidator.validateLetter(scanner).charAt(0);

            checkLetter(letter);
        }

        if (lives == 0)
        {
            System.out.println("You lost!");
        }
        else
        {
            System.out.println("Good job! The secret word was: " + word);
        }

        scanner.close();
    }

    public String createWord()
    {
        String rules = """
            Hi! Please enter a word that has:
            a) at least 2 characters
            b) at most 64 characters
            Have fun!
            """;

        Scanner scanner = new Scanner(System.in);
        System.out.print(rules);
        return scannerValidator.validateWord(scanner);
    }

    private void checkLetter(char letter)
    {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); ++i)
        {
            if (word.charAt(i) == letter)
            {
                userWord[i] = letter;
                foundLetter = true;
            }
        }

        if (!foundLetter)
        {
            System.out.println("There is no such letter.");
            --lives;
        }
    }

    private boolean gameEnded()
    {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}