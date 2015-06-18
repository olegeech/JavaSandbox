package LongDivCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Oleg on 18.06.2015.
 */
public class CalculatorHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int getUserInput(String inputText) throws IOException {
        int userInput = 0;
        System.out.print(inputText);
        boolean isError = true;
        while (isError) {
            try {
                userInput = Integer.parseInt(bufferedReader.readLine());
                isError = false;
            } catch (NumberFormatException nfe) {
                System.err.println("Inappropriate number format. Please use integer");
                isError = true;
            }
        }
        return userInput;
    }
}
