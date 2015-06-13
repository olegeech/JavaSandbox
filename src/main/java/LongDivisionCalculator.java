/**
 * Created by Oleg on 21.08.2014.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Long devision calculator
 *
 * Regex being used is (\\d+?)\\1 where
 * \\d        - means a numerical digit
 * \\d+       - means 1 or more occurrences of a digit
 * \\d+?      - means reluctant (non-greedy) match of 1 OR more digits
 * ( and )    - to group the above regex into group # 1
 * \\1        - means back reference to group # 1
 * (\\d+?)\\1 - repeat the group # 1 immediately after group # 1
 *
 *
 *
 */

public class LongDivisionCalculator {
    public static void main(String[] args) throws IOException {
        int numerator = 0;
        int denominator = 0;
        int result = 0;
        boolean point = false;
        String resultString = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printNewLine("Welcome to long devision calculator");
        numerator = input(numerator, bufferedReader, "Please enter numerator   : ");
        denominator = input(denominator, bufferedReader, "Please enter de-numerator: ");
        printNewLine(numerator + " | " + denominator);

        do {
            //if numerator less then de-numerator
            int i = 0;
            while (numerator < denominator) {
                if (i > 0) {
                    resultString += "0";
                }
                if (!point) {
                    resultString += ".";
                    point = true;
                }
                numerator *= 10;
                i++;
            }

            System.out.println(numerator);

            while (numerator >= denominator) {
                numerator -= denominator;
                result++;
            }
            resultString += (String.valueOf(result));
            result = 0;

            //verify devision period
            String regex = "(\\d+?)\\1";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(resultString);
            if (matcher.find()) {
                System.out.println(resultString.substring(0, matcher.group(1).length() + 2) + "(" + matcher.group(1)+ ")");
                break;
            } else {
                System.out.println(resultString);
            }
        } while (numerator!=0);


        printNewLine("\nHave a nice day! :)");
    }

    private static void printNewLine(String text) {
        System.out.println(text);
    }

    private static int input(int i, BufferedReader br, String inputText) throws IOException {
        System.out.print(inputText);
        boolean isError = true;
        while (isError) {
            try {
                i = Integer.parseInt(br.readLine());
                isError = false;
            } catch (NumberFormatException nfe) {
                System.err.println("Inappropriate number format. Please use integer");
                isError = true;
            }
        }
        return i;
    }
}
