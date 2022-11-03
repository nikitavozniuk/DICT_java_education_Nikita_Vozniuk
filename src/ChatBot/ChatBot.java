package ChatBot;

import java.io.*;

public class ChatBot {
    public static void test() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");

        System.out.println("1. To repeat a statement multiple lines.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        while (true) {
            String answer = bufferedReader.readLine();
            int parsedAnswer = Integer.parseInt(answer);

            if (parsedAnswer != 2) {
                System.out.println("Please, try again.");
                continue;
            } else {
                System.out.println("Great, you're right!");
                break;
            }
        }
        System.out.println("Goodbye, have a nice day!");
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Hello! My name is Carmen-Bot.");
        System.out.println("I was created in 2022.");

        System.out.println("Please, remind me your name.");
        String name = bufferedReader.readLine();
        String output = String.format("What a great name you have, %s!", name);

        System.out.println(output);

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        String remainder3 = bufferedReader.readLine();
        String remainder5 = bufferedReader.readLine();
        String remainder7 = bufferedReader.readLine();

        int parsedRemainder3 = Integer.parseInt(remainder3);
        int parsedRemainder5 = Integer.parseInt(remainder5);
        int parsedRemainder7 = Integer.parseInt(remainder7);

        int age = (parsedRemainder3 * 70 + parsedRemainder5 * 21 + parsedRemainder7 * 15) % 105;

        String ageOutput = String.format("Your age is %d; that's a good time to start programming!", age);

        System.out.println(ageOutput);

        System.out.println("Now I will prove to you that I can count to any number you want.");

        String countNumber = bufferedReader.readLine();
        int parsedCountNumber = Integer.parseInt(countNumber);
        int counter = 0;

        for (int i = 0; i < parsedCountNumber + 1; i++) {
            String counterOutput = String.format("%d !", counter);
            System.out.println(counterOutput);
            counter++;
        }

        test();
    }
}
