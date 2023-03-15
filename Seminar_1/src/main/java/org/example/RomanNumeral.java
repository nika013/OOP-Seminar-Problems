/**
 * Object of RomanNumeral class represents number in a range [1, 3999]
 * It can be created via roman number or arabic number. This class allows us to
 * convert roman number to arabic number and vice-verca.
 */

package org.example;

import org.jetbrains.annotations.NotNull;

public class RomanNumeral {
    private int number;
    private String[] romanNums = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private int[] arabNums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};


    public RomanNumeral(int arabicNumber) {
        number = arabicNumber;
    }

    public RomanNumeral(String romanNumber) {
        number = convertToArabic(romanNumber);
    }

    @Override
    public String toString() {
        String res = "";
        int curNumber = number;

        for (int i = arabNums.length-1; i >= 0; i--) {
            int curArabNum = arabNums[i];

            while (curNumber / curArabNum >= 1) {
                curNumber -= curArabNum;
                res += romanNums[i];
            }
        }

        return res;
    }

    public int toInt() {
        return number;
    }

    private int convertToArabic(@NotNull String romanNumber) {
        int curNumber = 0;

        for (int i = 0; i < romanNumber.length()-1; i++) {
            int num1 = charToInt(romanNumber.charAt(i));
            int num2 = charToInt(romanNumber.charAt(i+1));

            if (num1 < num2) {
                curNumber -= num1;
            } else {
                curNumber += num1;
            }
        }

        curNumber += charToInt(romanNumber.charAt(romanNumber.length()-1)); // add last character

        return curNumber;
    }

    private int charToInt(char roman) {
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new NumberFormatException("roman number is not valid");
        }
    }

}
