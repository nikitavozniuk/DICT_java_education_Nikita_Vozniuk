package Hangman;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        final String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        String wordToGuess = words[index];
        String hint = wordToGuess.replaceAll(wordToGuess.substring(2), "-".repeat(wordToGuess.length() - 2));
        String guessTheWordText = String.format("Guess the word %s: ", hint);

        System.out.println("HANGMAN");
        System.out.print(guessTheWordText);

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        if (Objects.equals(name, wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
