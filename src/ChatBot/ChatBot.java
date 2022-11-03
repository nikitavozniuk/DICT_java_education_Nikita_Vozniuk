package ChatBot;

import java.io.*;

public class ChatBot {
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
    }
}
