package com.calc;


import java.util.Scanner;


public class DataReader {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static int result;
    private boolean exitFlag;
    private final char exitCharacter;


    public DataReader(char exitCharacter) {
        this.exitCharacter = exitCharacter;
    }

    public void read() {

        boolean flag = false;
        System.out.println("Please, enter 0-10, or I-X (Example:2+2):");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Вызываем массив  under_char
        char[] under_char = Chars.getChars(userInput);

        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]", 2);

        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = RomanToNum.romanToNumber(stable00);
        number2 = RomanToNum.romanToNumber(string03);
        try {
            if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {


                number1 = Integer.parseInt(stable00);
                number2 = Integer.parseInt(string03);
                result = Calculator.calculated(number1, number2, Chars.getOperation());
                System.out.println("--Result for Arabic numerals----");
                System.out.println(number1 + " " + Chars.getOperation() + " " + number2 + " = " + result);

            } else if (stable00.equals(blacks[0]) || string03.equals(blacks[1])) {

                flag = true;

                result = Calculator.calculated(number1, number2, Chars.getOperation());
                System.out.println("---Result for Roman numerals----");
                String resultRoman = ConvertRoman.convertNumToRoman(result);
                System.out.println(stable00 + " " + Chars.getOperation() + " " + string03 + " = " + resultRoman);

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");

        }
    }


    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }


}