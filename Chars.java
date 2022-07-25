package com.calc;

public class Chars {
    private static char operation;

    public static char getOperation() {
        return operation;
    }

    public static char[] getChars(String userInput) {


        char[] under_char = new char[10];

//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции

        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        return under_char;
    }

}
