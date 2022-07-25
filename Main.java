package com.calc;


public class Main {
    private static final char exitCharacter = '!';

    public static void main(String[] args) {
        DataReader reader = new DataReader(exitCharacter);
        while (true) {
            try {
                reader.read();
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
            if (reader.isExitFlag()) {
                System.out.println("The expression contains an exit sign: " + exitCharacter);
                System.out.println("End of the program.");
                break;
            }
        }
    }
}