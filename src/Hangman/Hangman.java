package Hangman;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String GAME_NAME = "HANGMAN";
    private static final String RUNNING = "play";
    private static final String EXIT = "exit";
    private static final String GAME_STAGE = "Type 'play' to play the game, 'exit' to quit: > ";
    private static final String SINGLE_LETTER = "You should input a single letter.";
    private static final String LOWER_CASE_LETTER = "Please enter a lowercase English letter.";
    private static final String GUESS_CONDITION = "You've already guessed this letter.";
    private static final String LETTER_NOT_EXISTS = "That letter doesn't appear in the word.";

    static int attempts = 0;
    static int attemptsPossible = 8;
    static ArrayList<String> chars = new ArrayList<String>();
    static String wordToGuess = "";
    static String wordInput = "";
    static String isRunning = RUNNING;

    public static void startGame() {
        corePrep();
        System.out.println(GAME_NAME);
    }

    public static void menu() {
        while (!Objects.equals(isRunning, EXIT)) {
            System.out.print(GAME_STAGE);
            Scanner in = new Scanner(System.in);
            isRunning = in.nextLine();

            if (Objects.equals(isRunning, EXIT)) {
                break;
            }

            core();
            corePrep();
        }
    }

    public static Boolean checkWin() {
        return Objects.equals(wordInput, wordToGuess);
    }

    public static void updateWord(String word, String c) {
        for (int index = wordToGuess.indexOf(c);
             index >= 0;
             index = wordToGuess.indexOf(c, index + 1))
        {
            word = word.substring(0, index) + c + word.substring(index + 1);
        }
        wordInput = word;
    }

    public static void checkInput(String input) {
        if (input.length() > 1) {
            System.out.println(SINGLE_LETTER);
            return;
        }
        if (!input.matches("[a-zA-Z]+")) {
            System.out.println(LOWER_CASE_LETTER);
            return;
        }

        if (wordToGuess.contains(input) && !chars.contains(input)) {
            updateWord(wordInput, input);
            chars.add(input);
        } else if (chars.contains(input)) {
            System.out.println(GUESS_CONDITION);
            attemptsPossible--;
        } else {
            System.out.println(LETTER_NOT_EXISTS);
            attemptsPossible--;
        }
    }

    public static void corePrep() {
        attempts = 0;
        attemptsPossible = 8;
        chars = new ArrayList<String>();
        wordToGuess = "";
        wordInput = "";
        final String[] words = { "python", "java", "javascript", "kotlin" };
        Random random = new Random();
        int index = random.nextInt(words.length);
        wordToGuess = words[index];
    }

    public static void core() {
        wordInput = wordToGuess.replaceAll("(?s).", "-");

        while (attemptsPossible >= attempts & !Objects.equals(wordInput, wordToGuess)) {
            System.out.println(wordInput);
            System.out.print("Input a letter: > ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            checkInput(input);
        }

        Boolean result = checkWin();

        System.out.println("\nThanks for playing!");
        if (result) {
            System.out.println("You win!\n");
        } else {
            System.out.println("You lose!\n");
        }
    }

    public static void main(String[] args) {
        startGame();
        menu();
    }
}
