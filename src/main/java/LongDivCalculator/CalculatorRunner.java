package LongDivCalculator; /**
 * Created by Oleg on 21.08.2014.
 */

import java.io.IOException;
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

public class CalculatorRunner {
    public static void main(String[] args) throws IOException {
        CalculatorHelper helper = new CalculatorHelper();
        int numerator;
        int denominator;
        int result = 0;
        boolean point = false;
        String resultString = "";

        helper.printNewLine("Welcome to long devision calculator");
        numerator   = helper.getUserInput("Please enter numerator   : ");
        denominator = helper.getUserInput("Please enter de-numerator: ");

        helper.printNewLine(numerator + " | " + denominator);

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

            helper.printNewLine(String.valueOf(numerator));

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
                String divPeriod = matcher.group(1);
                resultString = resultString.substring(0, divPeriod.length() + 2); //substring resultString by div period
                helper.printNewLine(resultString + "(" + divPeriod + ")");
                break;
            } else if (numerator == 0) {
                helper.printNewLine(resultString);
            }
        } while (numerator!=0);


        helper.printNewLine("\nHave a nice day! :)");
    }
}
