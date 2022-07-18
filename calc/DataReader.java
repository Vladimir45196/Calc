package com.calc;

import java.util.Scanner;

public class DataReader {

    private int number1;
    private int number2;
    private char operation;
    private boolean exitFlag;
    private final char exitCharacter;
    private final char resultChar;

    public DataReader(char exitCharacter) {
        this.exitCharacter = exitCharacter;
        this.resultChar = '=';
    }


    public void read() {

        Integer[] arabSymbols = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] romanSymbols = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        System.out.println("Please, enter 0-10, or I-X with operation [+-/*] (Example:2+2=): ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (text.indexOf(exitCharacter) != -1) {
            exitFlag = true;
            return;
        }

        try {
            if ((text.charAt(text.length() - 1) != resultChar)) {
                throw new RuntimeException();
            }

            text = text.substring(0, text.length() - 1);
            String[] blocks = text.split("[+-/*]");

            // проверяем, входит ли строка blocks[0] в массив строк массива "romanSymbols"
            boolean flag = false;
            for (String romanSymbol : romanSymbols) {
                if (romanSymbol.equals(blocks[0]) || romanSymbol.equals(blocks[1])) {
                    flag = true;
                }
                //flag = true - будут Римские обозначения
                if (flag) {
                    number1 = romanToNumber(blocks[0]);
                    number2 = romanToNumber(blocks[1]);
                } else {
                    number1 = Integer.parseInt(blocks[0]);
                    number2 = Integer.parseInt(blocks[1]);
                }
                operation = text.charAt(blocks[0].length());

            }
            if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid data format");
        }
    }

    private static int romanToNumber(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public int getVar1() {
        return number1;
    }

    public int getVar2() {
        return number2;
    }

    public char getOperation() {
        return operation;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }
}
