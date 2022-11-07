package Hangman;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static int attempts = 0;
    static String wordToGuess = "";
    static String wordInput = "";

    public static void startGame() {
        final String[] words = { "python", "java", "javascript", "kotlin" };
        Random random = new Random();
        int index = random.nextInt(words.length);
        wordToGuess = words[index];
        System.out.println("HANGMAN");
    }

    public static void core() {
        int attemptsPossible = 8;
        ArrayList<String> chars = new ArrayList<String>();
        wordInput = wordToGuess.replaceAll("(?s).", "-");

        while (attemptsPossible >= attempts & !Objects.equals(wordInput, wordToGuess)) {
            System.out.println(wordInput);
            System.out.print("Input a letter: > ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (wordToGuess.contains(input) && !chars.contains(input)) {
                renderWord(wordInput, input);
                chars.add(input);
            } else if (chars.contains(input)) {
                System.out.println("No improvements");
                attemptsPossible--;
            } else {
                System.out.println("That letter doesn't appear in the word");
                attemptsPossible--;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("We'll see how well you did in the next stage");
    }

    public static void renderWord(String word, String c) {
        for (int index = wordToGuess.indexOf(c);
             index >= 0;
             index = wordToGuess.indexOf(c, index + 1))
        {
            word = word.substring(0, index) + c + word.substring(index + 1);
        }
        wordInput = word;
    }

    public static void main(String[] args) {
        startGame();
        core();
    }
}
